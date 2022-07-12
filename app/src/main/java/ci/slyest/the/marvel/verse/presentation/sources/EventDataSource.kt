package ci.slyest.the.marvel.verse.presentation.sources

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Event
import ci.slyest.the.marvel.verse.presentation.viewmodels.IEventViewModel
import io.reactivex.rxjava3.core.Single

class EventDataSource(var viewModel: IEventViewModel)
    : IMarvelDataSource<Event>() {

    class Factory(viewModel: IEventViewModel) : IMarvelDataSource.Factory<Event>() {
        override val source = EventDataSource(viewModel)
    }

    private var initSingle : Single<DataWrapper<Event>>? =
        viewModel.fetch(IEventViewModel.PAGE_SIZE + 2 * IEventViewModel.PREFETCH_DISTANCE).cache()

    init {
        disposable = initSingle!!.subscribe { wrapper ->
            disposable.dispose()
            count = wrapper.data.total
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Event>) {
        val data = initSingle!!.blockingGet().data.results
        val position = computeInitialLoadPosition(params, count!!)
//        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(data, position, count!!)
        initSingle = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Event>) {
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