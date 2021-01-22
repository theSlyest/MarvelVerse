package ci.slyest.the.marvel.verse.domain.entities

import java.util.Date

/**
 * Comic request class to carry the request parameters.
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
class ComicFilter (
    var characterId: Int? = null,
    var creatorId: Int? = null,
    var eventId: Int? = null,
    var seriesId: Int? = null,
    var storyId: Int? = null,
    /** Select one from: comic, magazine, trade paperback, hardcover, digest, graphic novel, digital comic, infinite comic */
    var format: String? = null,
    /** Select one from: comic, collection */
    var formatType: String? = null,
    var noVariants: Boolean? = null,
    /** Select one from: lastWeek, thisWeek, nextWeek, thisMonth */
    var dateDescriptor: String? = null,
    /** Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02). Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format. */
    var dateRange: String? = null,
    var title: String? = null,
    var titleStartsWith: String? = null,
    var startYear: Int? = null,
    var issueNumber: Int? = null,
    var diamondCode: String? = null,
    var digitalId: Int? = null,
    var upc: String? = null,
    var isbn: String? = null,
    var ean: String? = null,
    var issn: String? = null,
    var hasDigitalIssue: Boolean? = null,
    var modifiedSince: Date? = null,
    var creators: String? = null,
    var characters: String? = null,
    var series: String? = null,
    var events: String? = null,
    var stories: String? = null,
    var sharedAppearances: String? = null,
    var collaborators: String? = null,
    /** Select one or more from: focDate, onsaleDate, title, issueNumber, modified (add a "-" to the value sort in descending order) */
    var orderBy: String? = null,
    var limit: Int? = null,
    var offset: Int? = null
)