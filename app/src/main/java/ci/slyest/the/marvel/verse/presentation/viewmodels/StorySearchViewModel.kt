package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryRequest
import ci.slyest.the.marvel.verse.domain.usecases.StoriesUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.StoryDataSource
import io.reactivex.rxjava3.core.Single

class StorySearchViewModel(private val useCase: StoriesUseCase): IStoryViewModel(), ISearchViewModel<Story> {

    var request = StoryRequest()
    private lateinit var pagedList: LiveData<PagedList<Story>>
    override val data
        get() = pagedList

    override fun applyRequest() {
        pagedList =
            LivePagedListBuilder(StoryDataSource.Factory(this), pagingConfig).build()
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<StoryDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        request.limit = limit
        request.offset = offset
        useCase(request).let { single ->
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