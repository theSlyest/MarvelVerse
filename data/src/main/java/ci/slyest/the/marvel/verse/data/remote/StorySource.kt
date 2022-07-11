package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.StoryFilter
import io.reactivex.rxjava3.core.Single

class StorySource(private val storyService: StoryService) : IMarvelSource() {

    /**
     * Perform the right stories request according to the given parameters.
     * @param filter [StoryFilter] object carrying the request parameters.
     * @return [Single]<[StoryDataWrapper]> request result.
     */
    fun stories(filter: StoryFilter): Single<StoryDataWrapper> {
        val ts = getTimestamp()
        return when {
            filter.comicId != null ->
                storyService.comicStories(filter.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(filter.modifiedSince), filter.series, filter.events, filter.creators,
                    filter.characters, filter.orderBy, filter.limit, filter.offset)
            filter.eventId != null ->
                storyService.eventStories(filter.eventId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(filter.modifiedSince), filter.comics, filter.series, filter.creators,
                    filter.characters, filter.orderBy, filter.limit, filter.offset)
            filter.seriesId != null ->
                storyService.seriesStories(filter.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(filter.modifiedSince), filter.comics, filter.events, filter.creators,
                    filter.characters, filter.orderBy, filter.limit, filter.offset)
            filter.characterId != null ->
                storyService.characterStories(filter.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(filter.modifiedSince), filter.comics, filter.series, filter.events, filter.creators,
                    filter.orderBy, filter.limit, filter.offset)
            filter.creatorId != null ->
                storyService.creatorStories(filter.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(filter.modifiedSince), filter.comics, filter.series, filter.events, filter.characters,
                    filter.orderBy, filter.limit, filter.offset)
            else ->
                storyService.stories(PUBLIC_KEY, ts, getHash(ts), formatDate(filter.modifiedSince),
                    filter.comics, filter.series, filter.events, filter.creators, filter.characters,
                    filter.orderBy, filter.limit, filter.offset)
        }
    }
}