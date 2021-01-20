package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryRequest
import io.reactivex.rxjava3.core.Single

class StorySource(private val storyService: StoryService) : IMarvelSource() {

    fun stories(req: StoryRequest): Single<StoryDataWrapper> {
        val ts = getTimestamp()
        return when {
            req.comicId != null ->
                storyService.comicStories(req.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(req.modifiedSince), req.series, req.events, req.creators,
                    req.characters, req.orderBy, req.limit, req.offset)
            req.eventId != null ->
                storyService.eventStories(req.eventId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(req.modifiedSince), req.comics, req.series, req.creators,
                    req.characters, req.orderBy, req.limit, req.offset)
            req.seriesId != null ->
                storyService.seriesStories(req.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(req.modifiedSince), req.comics, req.events, req.creators,
                    req.characters, req.orderBy, req.limit, req.offset)
            req.characterId != null ->
                storyService.characterStories(req.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(req.modifiedSince), req.comics, req.series, req.events, req.creators,
                    req.orderBy, req.limit, req.offset)
            req.creatorId != null ->
                storyService.creatorStories(req.characterId!!, PUBLIC_KEY, ts, getHash(ts),
                    formatDate(req.modifiedSince), req.comics, req.series, req.events, req.characters,
                    req.orderBy, req.limit, req.offset)
            else ->
                storyService.stories(PUBLIC_KEY, ts, getHash(ts), formatDate(req.modifiedSince),
                    req.comics, req.series, req.events, req.creators, req.characters,
                    req.orderBy, req.limit, req.offset)
        }
    }
}