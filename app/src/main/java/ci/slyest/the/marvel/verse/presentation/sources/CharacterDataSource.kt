package ci.slyest.the.marvel.verse.presentation.sources

import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.presentation.viewmodels.ICharacterViewModel
import io.reactivex.rxjava3.core.Single

class CharacterDataSource(var viewModel: ICharacterViewModel)
    : IMarvelDataSource<Character>() {

    class Factory(viewModel: ICharacterViewModel) : IMarvelDataSource.Factory<Character>() {
        override val source = CharacterDataSource(viewModel)
    }

    private var initSingle : Single<DataWrapper<Character>>? =
        viewModel.fetch(ICharacterViewModel.PAGE_SIZE + 2 * ICharacterViewModel.PREFETCH_DISTANCE).cache()

    init {
        disposable = initSingle!!.subscribe { wrapper ->
            disposable.dispose()
            count = wrapper.data.total
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Character>) {
        val data = initSingle!!.blockingGet().data.results
        val position = computeInitialLoadPosition(params, count!!)
//        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(data, position, count!!)
        initSingle = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Character>) {
        if (!waiting) {
            disposable = viewModel.fetch(params.loadSize, params.startPosition)
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