package ci.slyest.the.marvel.verse.presentation.sources

import ci.slyest.the.marvel.verse.domain.entities.Series
import ci.slyest.the.marvel.verse.presentation.viewmodels.ISeriesViewModel

class SeriesDataSource(var viewModel: ISeriesViewModel)
    : IMarvelDataSource<Series>() {

    class Factory(viewModel: ISeriesViewModel) : IMarvelDataSource.Factory<Series>() {
        override val source = SeriesDataSource(viewModel)
    }

    private var initSingle =
        viewModel.fetch(ISeriesViewModel.PAGE_SIZE + 2 * ISeriesViewModel.PREFETCH_DISTANCE).cache()

    init {
        disposable = initSingle.subscribe { wrapper ->
            disposable.dispose()
            count = wrapper.data.total
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Series>) {
        val data = initSingle.blockingGet().data.results
        val position = computeInitialLoadPosition(params, count!!)
//        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(data, position, count!!)
        initSingle = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Series>) {
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