package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.EventRequest
import io.reactivex.rxjava3.core.Single

interface EventRepository {

    fun events(eventRequest: EventRequest): Single<EventDataWrapper>
}