package ci.slyest.the.marvel.verse.presentation.sources

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.presentation.viewmodels.IStoryViewModel
import io.reactivex.rxjava3.core.Single

class StoryDataSource(var viewModel: IStoryViewModel)
    : IMarvelDataSource<Story>() {

    class Factory(viewModel: IStoryViewModel) : IMarvelDataSource.Factory<Story>() {
        override val source = StoryDataSource(viewModel)
    }

    private var initSingle : Single<DataWrapper<Story>>? =
        viewModel.fetch(IStoryViewModel.PAGE_SIZE + 2 * IStoryViewModel.PREFETCH_DISTANCE).cache()

    init {
        disposable = initSingle!!.subscribe { wrapper ->
            disposable.dispose()
            count = wrapper.data.total
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Story>) {
        val data = initSingle!!.blockingGet().data.results
        val position = computeInitialLoadPosition(params, count!!)
//        val loadSize = computeInitialLoadSize(params, position, count!!)

        callback.onResult(data, position, count!!)
        initSingle = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Story>) {
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