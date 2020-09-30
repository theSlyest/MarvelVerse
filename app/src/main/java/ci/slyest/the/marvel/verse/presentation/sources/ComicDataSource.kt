package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.PositionalDataSource
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.presentation.repositories.PAGE_SIZE
import ci.slyest.the.marvel.verse.presentation.repositories.PREFETCH_DISTANCE
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import io.reactivex.rxjava3.disposables.Disposable

class ComicDataSource(private val viewModel: ComicViewModel)
    : PositionalDataSource<Comic>() {

    private var count: Int? = null

    private lateinit var disposable: Disposable
    private var waiting = false
    private val initSingle = viewModel.characters(PAGE_SIZE + 2 * PREFETCH_DISTANCE)

    init {
        initSingle.blockingSubscribe { wrapper ->
            count = wrapper.data.total
        }
    }

    private fun dispose() {
        waiting = false
        disposable.dispose()
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Character>) {
        val position = computeInitialLoadPosition(params, count!!)
        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(initSingle.blockingGet().data.results, position, count!!)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Character>) {
        if (!waiting) {
            disposable = viewModel.characters(params.loadSize, params.startPosition)
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