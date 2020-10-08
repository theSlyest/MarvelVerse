package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import io.reactivex.rxjava3.core.Single
import java.util.*

class ComicSource(private val comicService: ComicService) : IMarvelSource() {

    fun comics(
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: String?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?, // yyyy-MM-ddThh:mm
        creators: String?,
        characters: String?,
        series: String?,
        events: String?,
        stories: String?,
        sharedAppearances: String?,
        collaborators: String?,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return comicService.comics(
            PUBLIC_KEY, ts, getHash(ts), format, formatType, noVariants, dateDescriptor,
            dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc,
            isbn, ean, issn, hasDigitalIssue, formatDate(modifiedSince), creators, characters, series,
            events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
    }

    fun characterComics(
        characterId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: String?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?, // yyyy-MM-ddThh:mm
        creators: String?,
        series: String?,
        events: String?,
        stories: String?,
        sharedAppearances: String?,
        collaborators: String?,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return comicService.characterComics(
            characterId, PUBLIC_KEY, ts, getHash(ts), format, formatType, noVariants, dateDescriptor,
            dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc,
            isbn, ean, issn, hasDigitalIssue, formatDate(modifiedSince), creators, series,
            events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
    }

    fun creatorComics(
        creatorId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: String?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?, // yyyy-MM-ddThh:mm
        characters: String?,
        series: String?,
        events: String?,
        stories: String?,
        sharedAppearances: String?,
        collaborators: String?,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return comicService.creatorComics(
            creatorId, PUBLIC_KEY, ts, getHash(ts), format, formatType, noVariants, dateDescriptor,
            dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc,
            isbn, ean, issn, hasDigitalIssue, formatDate(modifiedSince), characters, series,
            events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
    }

    fun eventComics(
        eventId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: String?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?, // yyyy-MM-ddThh:mm
        creators: String?,
        characters: String?,
        series: String?,
        stories: String?,
        sharedAppearances: String?,
        collaborators: String?,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return comicService.eventComics(
            eventId, PUBLIC_KEY, ts, getHash(ts), format, formatType, noVariants, dateDescriptor,
            dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc,
            isbn, ean, issn, hasDigitalIssue, formatDate(modifiedSince), creators, characters, series,
            stories, sharedAppearances, collaborators, orderBy, limit, offset)
    }

    fun seriesComics(
        seriesId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: String?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?, // yyyy-MM-ddThh:mm
        creators: String?,
        characters: String?,
        events: String?,
        stories: String?,
        sharedAppearances: String?,
        collaborators: String?,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return comicService.seriesComics(
            seriesId, PUBLIC_KEY, ts, getHash(ts), format, formatType, noVariants, dateDescriptor,
            dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc,
            isbn, ean, issn, hasDigitalIssue, formatDate(modifiedSince), creators, characters,
            events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
    }

    fun storyComics(
        storyId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: String?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?, // yyyy-MM-ddThh:mm
        creators: String?,
        characters: String?,
        series: String?,
        events: String?,
        sharedAppearances: String?,
        collaborators: String?,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<ComicDataWrapper> {
        val ts = getTimestamp()
        return comicService.storyComics(
            storyId, PUBLIC_KEY, ts, getHash(ts), format, formatType, noVariants, dateDescriptor,
            dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc,
            isbn, ean, issn, hasDigitalIssue, formatDate(modifiedSince), creators, characters, series,
            events, sharedAppearances, collaborators, orderBy, limit, offset)
    }
}