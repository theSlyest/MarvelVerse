package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicRequest
import io.reactivex.rxjava3.core.Single
import java.util.*

class ComicSource(private val comicService: ComicService) : IMarvelSource() {

    fun comics(req: ComicRequest): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return when {
            req.characterId != null ->
                comicService.characterComics(req.characterId!!, PUBLIC_KEY, ts, getHash(ts), req.format,
                    req.formatType, req.noVariants, req.dateDescriptor, req.dateRange, req.title,
                    req.titleStartsWith, req.startYear, req.issueNumber, req.diamondCode, req.digitalId,
                    req.upc, req.isbn, req.ean, req.issn, req.hasDigitalIssue, formatDate(req.modifiedSince),
                    req.creators, req.series, req.events, req.stories, req.sharedAppearances,
                    req.collaborators, req.orderBy, req.limit, req.offset)
            req.creatorId != null ->
                comicService.creatorComics(req.creatorId!!, PUBLIC_KEY, ts, getHash(ts), req.format,
                    req.formatType, req.noVariants, req.dateDescriptor, req.dateRange, req.title,
                    req.titleStartsWith, req.startYear, req.issueNumber, req.diamondCode, req.digitalId,
                    req.upc, req.isbn, req.ean, req.issn, req.hasDigitalIssue, formatDate(req.modifiedSince),
                    req.characters, req.series, req.events, req.stories, req.sharedAppearances,
                    req.collaborators, req.orderBy, req.limit, req.offset)
            req.eventId != null ->
                comicService.eventComics(req.eventId!!, PUBLIC_KEY, ts, getHash(ts), req.format,
                    req.formatType, req.noVariants, req.dateDescriptor, req.dateRange, req.title,
                    req.titleStartsWith, req.startYear, req.issueNumber, req.diamondCode, req.digitalId,
                    req.upc, req.isbn, req.ean, req.issn, req.hasDigitalIssue, formatDate(req.modifiedSince),
                    req.creators, req.characters, req.series, req.stories, req.sharedAppearances,
                    req.collaborators, req.orderBy, req.limit, req.offset)
            req.seriesId != null ->
                comicService.seriesComics(req.seriesId!!, PUBLIC_KEY, ts, getHash(ts), req.format,
                    req.formatType, req.noVariants, req.dateDescriptor, req.dateRange, req.title,
                    req.titleStartsWith, req.startYear, req.issueNumber, req.diamondCode, req.digitalId,
                    req.upc, req.isbn, req.ean, req.issn, req.hasDigitalIssue, formatDate(req.modifiedSince),
                    req.creators, req.characters, req.events, req.stories, req.sharedAppearances,
                    req.collaborators, req.orderBy, req.limit, req.offset)
            req.storyId != null ->
                comicService.storyComics(req.storyId!!, PUBLIC_KEY, ts, getHash(ts), req.format,
                    req.formatType, req.noVariants, req.dateDescriptor, req.dateRange, req.title,
                    req.titleStartsWith, req.startYear, req.issueNumber, req.diamondCode, req.digitalId,
                    req.upc, req.isbn, req.ean, req.issn, req.hasDigitalIssue, formatDate(req.modifiedSince),
                    req.creators, req.characters, req.series, req.events, req.sharedAppearances,
                    req.collaborators, req.orderBy, req.limit, req.offset)
            else -> 
                comicService.comics(PUBLIC_KEY, ts, getHash(ts), req.format, req.formatType,
                    req.noVariants, req.dateDescriptor, req.dateRange, req.title, req.titleStartsWith,
                    req.startYear, req.issueNumber, req.diamondCode, req.digitalId, req.upc, req.isbn,
                    req.ean, req.issn, req.hasDigitalIssue, formatDate(req.modifiedSince), req.creators,
                    req.characters, req.series, req.events, req.stories, req.sharedAppearances,
                    req.collaborators, req.orderBy, req.limit, req.offset)
        }
    }
}