package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

class ComicsUseCase : KoinComponent {

    private val comicRepository: ComicRepository by inject()

    operator fun invoke(
        characterId: Int? = null,
        creatorId: Int? = null,
        eventId: Int? = null,
        seriesId: Int? = null,
        storyId: Int? = null,
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: String? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: String? = null,
        characters: String? = null,
        series: String? = null,
        events: String? = null,
        stories: String? = null,
        sharedAppearances: String? = null,
        collaborators: String? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<ComicDataWrapper> =
        when {
            characterId != null ->
                comicRepository.characterComics(characterId, format, formatType, noVariants, dateDescriptor,
                    dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId,
                    upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators, series, events,
                    stories, sharedAppearances, collaborators, orderBy, limit, offset)
            creatorId != null ->
                comicRepository.creatorComics(creatorId, format, formatType, noVariants, dateDescriptor,
                    dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId,
                    upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, characters, series, events,
                    stories, sharedAppearances, collaborators, orderBy, limit, offset)
            eventId != null ->
                comicRepository.eventComics(eventId, format, formatType, noVariants, dateDescriptor,
                    dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId,
                    upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators, characters, series,
                    stories, sharedAppearances, collaborators, orderBy, limit, offset)
            seriesId != null ->
                comicRepository.seriesComics(seriesId, format, formatType, noVariants, dateDescriptor,
                    dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId,
                    upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators, characters,
                    events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
            storyId != null ->
                comicRepository.storyComics(storyId, format, formatType, noVariants, dateDescriptor,
                    dateRange, title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId,
                    upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators, characters, series,
                    events, sharedAppearances, collaborators, orderBy, limit, offset)
            else ->
                comicRepository.comics(format, formatType, noVariants, dateDescriptor, dateRange,
                    title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc,
                    isbn, ean, issn, hasDigitalIssue, modifiedSince, creators, characters, series,
                    events, stories, sharedAppearances, collaborators, orderBy, limit, offset)
        }
}