package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.ComicSource
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import io.reactivex.rxjava3.core.Single
import java.util.*

class ComicRepositoryImpl(private val comicSource: ComicSource): ComicRepository {

    override fun comics(
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
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): Single<ComicDataWrapper>
            = comicSource.comics(format, formatType, noVariants, dateDescriptor, dateRange, title,
        titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc, isbn, ean, issn,
        hasDigitalIssue, modifiedSince, creators, characters, series, events, stories,
        sharedAppearances, collaborators, orderBy, limit, offset)
}