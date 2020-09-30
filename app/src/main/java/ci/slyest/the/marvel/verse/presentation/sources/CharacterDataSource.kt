package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.PositionalDataSource
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import io.reactivex.rxjava3.disposables.Disposable

class CharacterDataSource(private val viewModel: CharacterViewModel)
    : PositionalDataSource<Character>() {

    private var count: Int? = null

    private lateinit var disposable: Disposable
    private var waiting = false

    init {
        viewModel.characters(1)
            .blockingSubscribe { wrapper ->
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

        if (!waiting) {
            disposable = viewModel.characters(loadSize, position)
                .subscribe({ wrapper ->
                    dispose()
                    callback.onResult(wrapper.data.results, position, count!!)
                }, {
                    dispose()
                    loadInitial(params, callback)
                })
            waiting = true
        }
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