package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.EventRequest
import io.reactivex.rxjava3.core.Single

class EventSource(private val eventService: EventService) : IMarvelSource() {

    fun events(req: EventRequest): Single<EventDataWrapper> {
        val ts = getTimestamp()
        return when {
            req.comicId != null ->
                eventService.comicEvents(req.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.creators,
                    req.characters, req.series, req.stories, req.orderBy, req.limit, req.offset)
            req.characterId != null ->
                eventService.characterEvents(req.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.creators,
                    req.series, req.comics, req.stories, req.orderBy, req.limit, req.offset)
            req.seriesId != null ->
                eventService.seriesEvents(req.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.creators,
                    req.characters, req.comics, req.stories, req.orderBy, req.limit, req.offset)
            req.storyId != null ->
                eventService.storyEvents(req.storyId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.creators,
                    req.characters, req.series, req.comics, req.orderBy, req.limit, req.offset)
            else ->
                eventService.events(PUBLIC_KEY, ts, getHash(ts), req.name, req.nameStartsWith,
                    formatDate(req.modifiedSince), req.creators, req.characters, req.series,
                    req.comics, req.stories, req.orderBy, req.limit, req.offset)
        }
    }
}