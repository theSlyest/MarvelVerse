package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import io.reactivex.rxjava3.core.Single
import java.util.*

interface ComicRepository {

    fun comics(
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
    ): Single<ComicDataWrapper>
}