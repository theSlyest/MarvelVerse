package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.EventSource
import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.EventRequest
import ci.slyest.the.marvel.verse.domain.repositories.EventRepository
import io.reactivex.rxjava3.core.Single

class EventRepositoryImpl(private val eventSource: EventSource) : EventRepository {

    override fun events(eventRequest: EventRequest): Single<EventDataWrapper>
            = eventSource.events(eventRequest)
}