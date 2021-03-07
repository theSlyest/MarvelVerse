package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Event
import ci.slyest.the.marvel.verse.domain.filters.EventFilter
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
     * @param eventFilter object carrying the request parameters.
     * @return a [Single]<[DataWrapper]<[Event]>> result object
     */
    operator fun invoke(eventFilter: EventFilter): Single<DataWrapper<Event>> =
        eventRepository.events(eventFilter)
}