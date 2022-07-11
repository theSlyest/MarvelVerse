package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.EventSource
import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.EventFilter
import ci.slyest.the.marvel.verse.domain.repositories.EventRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of [EventRepository]
 * @property eventSource [EventSource] object
 */
class EventRepositoryImpl(private val eventSource: EventSource) : EventRepository {
    /**
     * Perform a request to get a list of characters by calling [EventSource.events].
     * @param eventFilter Object carrying the request parameters
     * @return a [Single]<[EventDataWrapper]> result object
     */
    override fun events(eventFilter: EventFilter): Single<EventDataWrapper>
            = eventSource.events(eventFilter)
}