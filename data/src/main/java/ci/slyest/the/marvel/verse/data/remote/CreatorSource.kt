package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CreatorFilter
import io.reactivex.rxjava3.core.Single

/**
 * Source class for creator requests. Implements [IMarvelSource].
 * @property creatorService Required [CreatorService].
 */
class CreatorSource(private val creatorService: CreatorService) : IMarvelSource() {

    fun creators(req: CreatorFilter): Single<CreatorDataWrapper> {
        val ts = getTimestamp()
        return when {
            req.comicId != null ->
                creatorService.comicCreators(req.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.firstName, req.middleName, req.lastName, req.firstNameStartsWith,
                    req.middleNameStartsWith, req.lastNameStartsWith, formatDate(req.modifiedSince),
                    req.series, req.events, req.stories, req.orderBy, req.limit, req.offset)
            req.eventId != null ->
                creatorService.eventCreators(req.eventId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.firstName, req.middleName, req.lastName, req.firstNameStartsWith,
                    req.middleNameStartsWith, req.lastNameStartsWith, formatDate(req.modifiedSince),
                    req.comics, req.series, req.stories, req.orderBy, req.limit, req.offset)
            req.seriesId != null ->
                creatorService.seriesCreators(req.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.firstName, req.middleName, req.lastName, req.firstNameStartsWith,
                    req.middleNameStartsWith, req.lastNameStartsWith, formatDate(req.modifiedSince),
                    req.comics, req.events, req.stories, req.orderBy, req.limit, req.offset)
            req.storyId != null ->
                creatorService.storyCreators(req.storyId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.firstName, req.middleName, req.lastName, req.firstNameStartsWith,
                    req.middleNameStartsWith, req.lastNameStartsWith, formatDate(req.modifiedSince),
                    req.comics, req.series, req.events, req.orderBy, req.limit, req.offset)
            else ->
                creatorService.creators(PUBLIC_KEY, ts, getHash(ts), req.firstName, req.middleName,
                    req.lastName, req.firstNameStartsWith, req.middleNameStartsWith,
                    req.lastNameStartsWith, formatDate(req.modifiedSince), req.comics, req.series,
                    req.events, req.stories, req.orderBy, req.limit, req.offset)
        }
    }
}