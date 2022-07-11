package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.ComicFilter
import io.reactivex.rxjava3.core.Single

/**
 * Source class for comic requests. Implements [IMarvelSource].
 * @property comicService Required [ComicService].
 */
class ComicSource(private val comicService: ComicService) : IMarvelSource() {

    /**
     * Perform the right comics request according to the given parameters.
     * @param filter [ComicFilter] object carrying the request parameters.
     * @return [Single]<[ComicDataWrapper]> request result.
     */
    fun comics(filter: ComicFilter): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return when {
            filter.characterId != null ->
                comicService.characterComics(filter.characterId!!, PUBLIC_KEY, ts, getHash(ts), filter.format,
                    filter.formatType, filter.noVariants, filter.dateDescriptor, filter.dateRange, filter.title,
                    filter.titleStartsWith, filter.startYear, filter.issueNumber, filter.diamondCode, filter.digitalId,
                    filter.upc, filter.isbn, filter.ean, filter.issn, filter.hasDigitalIssue, formatDate(filter.modifiedSince),
                    filter.creators, filter.series, filter.events, filter.stories, filter.sharedAppearances,
                    filter.collaborators, filter.orderBy, filter.limit, filter.offset)
            filter.creatorId != null ->
                comicService.creatorComics(filter.creatorId!!, PUBLIC_KEY, ts, getHash(ts), filter.format,
                    filter.formatType, filter.noVariants, filter.dateDescriptor, filter.dateRange, filter.title,
                    filter.titleStartsWith, filter.startYear, filter.issueNumber, filter.diamondCode, filter.digitalId,
                    filter.upc, filter.isbn, filter.ean, filter.issn, filter.hasDigitalIssue, formatDate(filter.modifiedSince),
                    filter.characters, filter.series, filter.events, filter.stories, filter.sharedAppearances,
                    filter.collaborators, filter.orderBy, filter.limit, filter.offset)
            filter.eventId != null ->
                comicService.eventComics(filter.eventId!!, PUBLIC_KEY, ts, getHash(ts), filter.format,
                    filter.formatType, filter.noVariants, filter.dateDescriptor, filter.dateRange, filter.title,
                    filter.titleStartsWith, filter.startYear, filter.issueNumber, filter.diamondCode, filter.digitalId,
                    filter.upc, filter.isbn, filter.ean, filter.issn, filter.hasDigitalIssue, formatDate(filter.modifiedSince),
                    filter.creators, filter.characters, filter.series, filter.stories, filter.sharedAppearances,
                    filter.collaborators, filter.orderBy, filter.limit, filter.offset)
            filter.seriesId != null ->
                comicService.seriesComics(filter.seriesId!!, PUBLIC_KEY, ts, getHash(ts), filter.format,
                    filter.formatType, filter.noVariants, filter.dateDescriptor, filter.dateRange, filter.title,
                    filter.titleStartsWith, filter.startYear, filter.issueNumber, filter.diamondCode, filter.digitalId,
                    filter.upc, filter.isbn, filter.ean, filter.issn, filter.hasDigitalIssue, formatDate(filter.modifiedSince),
                    filter.creators, filter.characters, filter.events, filter.stories, filter.sharedAppearances,
                    filter.collaborators, filter.orderBy, filter.limit, filter.offset)
            filter.storyId != null ->
                comicService.storyComics(filter.storyId!!, PUBLIC_KEY, ts, getHash(ts), filter.format,
                    filter.formatType, filter.noVariants, filter.dateDescriptor, filter.dateRange, filter.title,
                    filter.titleStartsWith, filter.startYear, filter.issueNumber, filter.diamondCode, filter.digitalId,
                    filter.upc, filter.isbn, filter.ean, filter.issn, filter.hasDigitalIssue, formatDate(filter.modifiedSince),
                    filter.creators, filter.characters, filter.series, filter.events, filter.sharedAppearances,
                    filter.collaborators, filter.orderBy, filter.limit, filter.offset)
            else -> 
                comicService.comics(PUBLIC_KEY, ts, getHash(ts), filter.format, filter.formatType,
                    filter.noVariants, filter.dateDescriptor, filter.dateRange, filter.title, filter.titleStartsWith,
                    filter.startYear, filter.issueNumber, filter.diamondCode, filter.digitalId, filter.upc, filter.isbn,
                    filter.ean, filter.issn, filter.hasDigitalIssue, formatDate(filter.modifiedSince), filter.creators,
                    filter.characters, filter.series, filter.events, filter.stories, filter.sharedAppearances,
                    filter.collaborators, filter.orderBy, filter.limit, filter.offset)
        }
    }
}