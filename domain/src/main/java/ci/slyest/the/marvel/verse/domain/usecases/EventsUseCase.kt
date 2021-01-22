package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.EventRequest
import ci.slyest.the.marvel.verse.domain.repositories.EventRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Events list use case: depends on [EventRepository] implementation to perform a request.
 */
class EventsUseCase : KoinComponent {

    /** Injected [EventRepository] */
    private val eventRepository: EventRepository by inject()

    /**
     * Perform a request by calling the [EventRepository.events] method.
     * @param eventRequest object carrying the request parameters.
     * @return a [Single]<[EventDataWrapper]> result object
     */
    operator fun invoke(eventRequest: EventRequest): Single<EventDataWrapper> =
        eventRepository.events(eventRequest)
}