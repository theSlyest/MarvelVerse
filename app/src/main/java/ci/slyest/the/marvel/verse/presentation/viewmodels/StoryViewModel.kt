package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryFilter
import ci.slyest.the.marvel.verse.domain.usecases.StoriesUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.StoryDataSource
import io.reactivex.rxjava3.core.Single

class StoryViewModel(private val useCase: StoriesUseCase): IStoryViewModel() {

    companion object {
        @JvmStatic
        var pagedList: LiveData<PagedList<Story>>? = null
        @JvmStatic
        private var dataSource: StoryDataSource? = null
    }

    init {
        if (pagedList == null)
            StoryDataSource.Factory(this).let { factory ->
                pagedList = LivePagedListBuilder(factory, pagingConfig).build()
                dataSource = factory.source
            }
        else
            dataSource?.viewModel = this
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<StoryDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(StoryFilter(limit = limit, offset = offset)).let { single ->
            disposable = single.subscribe({
                mutableState.postValue(Response(status = Status.SUCCESSFUL))
                disposable.dispose()
            }, { error ->
                mutableState.postValue(Response(status = Status.ERROR, error = error))
                disposable.dispose()
            })
            return single
        }
    }
}