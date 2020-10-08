package ci.slyest.the.marvel.verse.presentation.sources

import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.presentation.viewmodels.IComicViewModel

class ComicDataSource(var viewModel: IComicViewModel)
    : IMarvelDataSource<Comic>() {
    private var initSingle =
        viewModel.fetch(IComicViewModel.PAGE_SIZE + 2 * IComicViewModel.PREFETCH_DISTANCE).cache()

    init {
        disposable = initSingle.subscribe { wrapper ->
            disposable.dispose()
            count = wrapper.data.total
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Comic>) {
        val data = initSingle.blockingGet().data.results
        val position = computeInitialLoadPosition(params, count!!)
//        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(data, position, count!!)
        initSingle = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Comic>) {
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