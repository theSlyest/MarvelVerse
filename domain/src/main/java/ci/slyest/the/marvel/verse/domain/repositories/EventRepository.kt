package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Event
import ci.slyest.the.marvel.verse.domain.filters.EventFilter
import io.reactivex.rxjava3.core.Single

/** Event repository interface to be implemented in the data module. */
interface EventRepository {
    /**
     * Perform a request to get a list of characters
     * @param eventFilter Object carrying the request parameters
     * @return a [Single]<[DataWrapper<Event>]> result object
     */
    fun events(eventFilter: EventFilter): Single<DataWrapper<Event>>
}