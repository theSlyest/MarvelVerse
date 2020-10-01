package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.PositionalDataSource
import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.presentation.repositories.PAGE_SIZE
import ci.slyest.the.marvel.verse.presentation.repositories.PREFETCH_DISTANCE
import ci.slyest.the.marvel.verse.presentation.viewmodels.ComicViewModel
import io.reactivex.rxjava3.disposables.Disposable

class ComicDataSource(private val viewModel: ComicViewModel)
    : PositionalDataSource<Comic>() {

    private var count: Int? = null

    private lateinit var disposable: Disposable
    private var waiting = false
    private var initSingle = viewModel.comics(PAGE_SIZE + 2 * PREFETCH_DISTANCE).cache()

    init {
        initSingle.blockingSubscribe { wrapper ->
            count = wrapper.data.total
        }
    }

    private fun dispose() {
        waiting = false
        disposable.dispose()
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Comic>) {
        val position = computeInitialLoadPosition(params, count!!)
//        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(initSingle.blockingGet().data.results, position, count!!)
        initSingle = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Comic>) {
        if (!waiting) {
            disposable = viewModel.comics(params.loadSize, params.startPosition)
                .subscribe({ wrapper ->
                    dispose()
                    callback.onResult(wrapper.data.results)
                }, {
                    dispose()
                    loadRange(params, callback)
                })
            waiting = true
        }
    }
}