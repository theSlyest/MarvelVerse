package ci.slyest.the.marvel.verse.presentation.sources

import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.presentation.viewmodels.ICreatorViewModel

class CreatorDataSource(var viewModel: ICreatorViewModel)
    : IMarvelDataSource<Creator>() {

    class Factory(viewModel: ICreatorViewModel) : IMarvelDataSource.Factory<Creator>() {
        override val source = CreatorDataSource(viewModel)
    }

    private var initSingle =
        viewModel.fetch(ICreatorViewModel.PAGE_SIZE + 2 * ICreatorViewModel.PREFETCH_DISTANCE).cache()

    init {
        disposable = initSingle.subscribe { wrapper ->
            disposable.dispose()
            count = wrapper.data.total
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Creator>) {
        val data = initSingle.blockingGet().data.results
        val position = computeInitialLoadPosition(params, count!!)
//        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(data, position, count!!)
        initSingle = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Creator>) {
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