package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.EventRequest
import ci.slyest.the.marvel.verse.domain.repositories.EventRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class EventsUseCase : KoinComponent {

    private val eventRepository: EventRepository by inject()

    operator fun invoke(eventRequest: EventRequest): Single<EventDataWrapper> =
        eventRepository.events(eventRequest)
}