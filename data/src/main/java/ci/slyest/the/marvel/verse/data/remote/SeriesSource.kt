package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesFilter
import io.reactivex.rxjava3.core.Single

class SeriesSource(private val seriesService: SeriesService) : IMarvelSource() {

    /**
     * Perform the right series request according to the given parameters.
     * @param filter [SeriesFilter] object carrying the request parameters.
     * @return [Single]<[SeriesDataWrapper]> request result.
     */
    fun series(filter: SeriesFilter): Single<SeriesDataWrapper> {
        val ts = getTimestamp()
        return when {
            filter.characterId != null ->
                seriesService.characterSeries(filter.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.title, filter.titleStartsWith, filter.startYear, formatDate(filter.modifiedSince),
                    filter.comics, filter.stories, filter.events, filter.creators, filter.seriesType, filter.contains,
                    filter.orderBy, filter.limit, filter.offset)
            filter.creatorId != null ->
                seriesService.creatorSeries(filter.creatorId!!, PUBLIC_KEY, ts, getHash(ts), filter.title,
                    filter.titleStartsWith, filter.startYear, formatDate(filter.modifiedSince), filter.comics,
                    filter.stories, filter.events, filter.characters, filter.seriesType, filter.contains,
                    filter.orderBy, filter.limit, filter.offset)
            filter.eventId != null ->
                seriesService.eventSeries(filter.eventId!!, PUBLIC_KEY, ts, getHash(ts), filter.title,
                    filter.titleStartsWith, filter.startYear, formatDate(filter.modifiedSince), filter.comics,
                    filter.stories, filter.creators, filter.characters, filter.seriesType, filter.contains,
                    filter.orderBy, filter.limit, filter.offset)
            filter.storyId != null ->
                seriesService.storySeries(filter.storyId!!, PUBLIC_KEY, ts, getHash(ts), filter.title,
                    filter.titleStartsWith, filter.startYear, formatDate(filter.modifiedSince), filter.comics,
                    filter.events, filter.creators, filter.characters, filter.seriesType, filter.contains,
                    filter.orderBy, filter.limit, filter.offset)
            else -> 
                seriesService.series(PUBLIC_KEY, ts, getHash(ts), filter.title, filter.titleStartsWith,
                    filter.startYear, formatDate(filter.modifiedSince), filter.comics, filter.stories, filter.events,
                    filter.creators, filter.characters, filter.seriesType, filter.contains, filter.orderBy, filter.limit, filter.offset)
        }
    }
}