package ci.slyest.the.marvel.verse.domain.entities

import java.util.*

class ComicRequest (
    var characterId: Int? = null,
    var creatorId: Int? = null,
    var eventId: Int? = null,
    var seriesId: Int? = null,
    var storyId: Int? = null,
    var format: String? = null,
    var formatType: String? = null,
    var noVariants: Boolean? = null,
    var dateDescriptor: String? = null,
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
    var orderBy: String? = null,
    var limit: Int? = null,
    var offset: Int? = null
)