package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

class ComicsUseCase : KoinComponent {

    private val comicRepository: ComicRepository by inject()

    operator fun invoke(
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
        modifiedSince: Date?,
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
    ): Single<ComicDataWrapper>
            = comicRepository.comics(format, formatType, noVariants, dateDescriptor, dateRange,
        title, titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc, isbn, ean,
        issn, hasDigitalIssue, modifiedSince, creators, characters, series, events, stories,
        sharedAppearances, collaborators, orderBy, limit, offset)
}