package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.PositionalDataSource
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import io.reactivex.rxjava3.disposables.Disposable

class CharacterDataSource(private val viewModel: CharacterViewModel)
    : PositionalDataSource<Character>() {

    private var count: Int? = null

    private lateinit var disposable: Disposable

    init {
        viewModel.characters(1)
            .blockingSubscribe { wrapper ->
                count = wrapper.data.total
            }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Character>) {
        val position = computeInitialLoadPosition(params, count!!)
        val loadSize = computeInitialLoadSize(params, position, count!!)

        disposable = viewModel.characters(loadSize, position)
            .subscribe({ wrapper ->
                disposable.dispose()
                callback.onResult(wrapper.data.results, position, count!!)
            }, {
                disposable.dispose()
                loadInitial(params, callback)
            })
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Character>) {
        disposable = viewModel.characters(params.loadSize, params.startPosition)
            .subscribe({ wrapper ->
                disposable.dispose()
                callback.onResult(wrapper.data.results)
            }, {
                disposable.dispose()
                loadRange(params, callback)
            })
    }
}