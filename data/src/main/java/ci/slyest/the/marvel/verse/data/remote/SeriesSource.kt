package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesFilter
import io.reactivex.rxjava3.core.Single

class SeriesSource(private val seriesService: SeriesService) : IMarvelSource() {

    fun series(req: SeriesFilter): Single<SeriesDataWrapper> {
        val ts = getTimestamp()
        return when {
            req.characterId != null ->
                seriesService.characterSeries(req.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.title, req.titleStartsWith, req.startYear, formatDate(req.modifiedSince),
                    req.comics, req.stories, req.events, req.creators, req.seriesType, req.contains,
                    req.orderBy, req.limit, req.offset)
            req.creatorId != null ->
                seriesService.creatorSeries(req.creatorId!!, PUBLIC_KEY, ts, getHash(ts), req.title,
                    req.titleStartsWith, req.startYear, formatDate(req.modifiedSince), req.comics,
                    req.stories, req.events, req.characters, req.seriesType, req.contains,
                    req.orderBy, req.limit, req.offset)
            req.eventId != null ->
                seriesService.eventSeries(req.eventId!!, PUBLIC_KEY, ts, getHash(ts), req.title,
                    req.titleStartsWith, req.startYear, formatDate(req.modifiedSince), req.comics,
                    req.stories, req.creators, req.characters, req.seriesType, req.contains,
                    req.orderBy, req.limit, req.offset)
            req.storyId != null ->
                seriesService.storySeries(req.storyId!!, PUBLIC_KEY, ts, getHash(ts), req.title,
                    req.titleStartsWith, req.startYear, formatDate(req.modifiedSince), req.comics,
                    req.events, req.creators, req.characters, req.seriesType, req.contains,
                    req.orderBy, req.limit, req.offset)
            else -> 
                seriesService.series(PUBLIC_KEY, ts, getHash(ts), req.title, req.titleStartsWith,
                    req.startYear, formatDate(req.modifiedSince), req.comics, req.stories, req.events,
                    req.creators, req.characters, req.seriesType, req.contains, req.orderBy, req.limit, req.offset)
        }
    }
}