package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.domain.entities.CreatorFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import io.reactivex.rxjava3.core.Single

/**
 * Source class for creator requests. Implements [IMarvelSource].
 * @property creatorService Required [CreatorService].
 */
class CreatorSource(private val creatorService: CreatorService) : IMarvelSource() {

    /**
     * Perform the right creators request according to the given parameters.
     * @param filter [CreatorFilter] object carrying the request parameters.
     * @return [Single]<[DataWrapper]<[Creator]>> request result.
     */
    fun creators(filter: CreatorFilter): Single<DataWrapper<Creator>> {
        val ts = getTimestamp()
        return when {
            filter.comicId != null ->
                creatorService.comicCreators(filter.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.firstName, filter.middleName, filter.lastName, filter.firstNameStartsWith,
                    filter.middleNameStartsWith, filter.lastNameStartsWith, formatDate(filter.modifiedSince),
                    filter.series, filter.events, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.eventId != null ->
                creatorService.eventCreators(filter.eventId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.firstName, filter.middleName, filter.lastName, filter.firstNameStartsWith,
                    filter.middleNameStartsWith, filter.lastNameStartsWith, formatDate(filter.modifiedSince),
                    filter.comics, filter.series, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.seriesId != null ->
                creatorService.seriesCreators(filter.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.firstName, filter.middleName, filter.lastName, filter.firstNameStartsWith,
                    filter.middleNameStartsWith, filter.lastNameStartsWith, formatDate(filter.modifiedSince),
                    filter.comics, filter.events, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.storyId != null ->
                creatorService.storyCreators(filter.storyId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.firstName, filter.middleName, filter.lastName, filter.firstNameStartsWith,
                    filter.middleNameStartsWith, filter.lastNameStartsWith, formatDate(filter.modifiedSince),
                    filter.comics, filter.series, filter.events, filter.orderBy, filter.limit, filter.offset)
            else ->
                creatorService.creators(PUBLIC_KEY, ts, getHash(ts), filter.firstName, filter.middleName,
                    filter.lastName, filter.firstNameStartsWith, filter.middleNameStartsWith,
                    filter.lastNameStartsWith, formatDate(filter.modifiedSince), filter.comics, filter.series,
                    filter.events, filter.stories, filter.orderBy, filter.limit, filter.offset)
        }
    }
}