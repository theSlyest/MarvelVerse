package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.EventRequest
import io.reactivex.rxjava3.core.Single

/** Event repository interface to be implemented in the data component. */
interface EventRepository {
    /**
     * Perform a request to get a list of characters
     * @param eventRequest Object carrying the request parameters
     * @return a [Single]<[EventDataWrapper]> result object
     */
    fun events(eventRequest: EventRequest): Single<EventDataWrapper>
}