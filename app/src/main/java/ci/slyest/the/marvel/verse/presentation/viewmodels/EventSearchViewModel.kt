package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Event
import ci.slyest.the.marvel.verse.domain.filters.EventFilter
import ci.slyest.the.marvel.verse.domain.usecases.EventsUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.EventDataSource
import io.reactivex.rxjava3.core.Single

class EventSearchViewModel(private val useCase: EventsUseCase): IEventViewModel(), ISearchViewModel<Event> {

    var request = EventFilter()
    private lateinit var pagedList: LiveData<PagedList<Event>>
    override val data
        get() = pagedList

    override fun applyRequest() {
        pagedList =
            LivePagedListBuilder(EventDataSource.Factory(this), pagingConfig).build()
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<DataWrapper<Event>> {
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