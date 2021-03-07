package ci.slyest.the.marvel.verse.domain.filters

import java.util.*

/**
 * Story request class to carry the request parameters.
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
class StoryFilter (
    var characterId: Int? = null,
    var comicId: Int? = null,
    var creatorId: Int? = null,
    var eventId: Int? = null,
    var seriesId: Int? = null,
    var modifiedSince: Date? = null,
    var comics: String? = null,
    var series: String? = null,
    var events: String? = null,
    var creators: String? = null,
    var characters: String? = null,
    /** Select one or more from: id, modified (add a "-" to the value sort in descending order) */
    var orderBy: String? = null,
    var limit: Int? = null,
    var offset: Int? = null
)