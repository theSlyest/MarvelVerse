package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Event
import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.EventRequest
import ci.slyest.the.marvel.verse.domain.usecases.EventsUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.EventDataSource
import io.reactivex.rxjava3.core.Single

class EventViewModel(private val useCase: EventsUseCase): IEventViewModel() {

    companion object {
        @JvmStatic
        var pagedList: LiveData<PagedList<Event>>? = null
        @JvmStatic
        private var dataSource: EventDataSource? = null
    }

    init {
        if (pagedList == null)
            EventDataSource.Factory(this).let { factory ->
                pagedList = LivePagedListBuilder(factory, pagingConfig).build()
                dataSource = factory.source
            }
        else
            dataSource?.viewModel = this
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<EventDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(EventRequest(limit = limit, offset = offset)).let { single ->
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