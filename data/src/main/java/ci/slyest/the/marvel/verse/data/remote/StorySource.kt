package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.domain.entities.StoryFilter
import io.reactivex.rxjava3.core.Single

class StorySource(private val storyService: StoryService) : IMarvelSource() {

    /**
     * Perform the right stories request according to the given parameters.
     * @param filter [StoryFilter] object carrying the request parameters.
     * @return [Single]<[DataWrapper]<[Story]>> request result.
     */
    fun stories(filter: StoryFilter): Single<DataWrapper<Story>> {
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