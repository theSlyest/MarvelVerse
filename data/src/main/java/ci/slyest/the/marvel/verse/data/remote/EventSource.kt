package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.EventFilter
import io.reactivex.rxjava3.core.Single

/**
 * Source class for event requests. Implements [IMarvelSource].
 * @property eventService Required [EventService].
 */
class EventSource(private val eventService: EventService) : IMarvelSource() {

    /**
     * Perform the right events request according to the given parameters.
     * @param filter [EventFilter] object carrying the request parameters.
     * @return [Single]<[EventDataWrapper]> request result.
     */
    fun events(filter: EventFilter): Single<EventDataWrapper> {
        val ts = getTimestamp()
        return when {
            filter.comicId != null ->
                eventService.comicEvents(filter.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.creators,
                    filter.characters, filter.series, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.characterId != null ->
                eventService.characterEvents(filter.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.creators,
                    filter.series, filter.comics, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.creatorId != null ->
                eventService.creatorEvents(filter.creatorId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.characters,
                    filter.series, filter.comics, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.seriesId != null ->
                eventService.seriesEvents(filter.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.creators,
                    filter.characters, filter.comics, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.storyId != null ->
                eventService.storyEvents(filter.storyId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.creators,
                    filter.characters, filter.series, filter.comics, filter.orderBy, filter.limit, filter.offset)
            else ->
                eventService.events(PUBLIC_KEY, ts, getHash(ts), filter.name, filter.nameStartsWith,
                    formatDate(filter.modifiedSince), filter.creators, filter.characters, filter.series,
                    filter.comics, filter.stories, filter.orderBy, filter.limit, filter.offset)
        }
    }
}