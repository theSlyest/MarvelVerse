package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import io.reactivex.rxjava3.core.Single
import java.text.SimpleDateFormat
import java.util.*

class ComicSource(private val marvelService: MarvelService) : IMarvelSource() {

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
        val hash = getHash(ts)
        val since: String? = modifiedSince?.run {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this)
        }
        return marvelService.comics(
            PUBLIC_KEY, ts, hash, format, formatType, noVariants, dateDescriptor, dateRange, title,
            titleStartsWith, startYear, issueNumber, diamondCode, digitalId, upc, isbn, ean, issn,
            hasDigitalIssue, since, creators, characters, series, events, stories,
            sharedAppearances, collaborators, orderBy, limit, offset)
    }
}