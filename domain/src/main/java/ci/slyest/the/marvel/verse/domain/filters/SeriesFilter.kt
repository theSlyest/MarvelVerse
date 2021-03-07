package ci.slyest.the.marvel.verse.domain.filters

import java.util.*

/**
 * Series request class to carry the request parameters.
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
class SeriesFilter (
    var characterId: Int? = null,
    var comicId: Int? = null,
    var creatorId: Int? = null,
    var eventId: Int? = null,
    var storyId: Int? = null,
    var title: String? = null,
    var titleStartsWith: String? = null,
    var startYear: Int? = null,
    var modifiedSince: Date? = null,
    var comics: String? = null,
    var stories: String? = null,
    var events: String? = null,
    var creators: String? = null,
    var characters: String? = null,
    /** Select one from: collection, one shot, limited, ongoing */
    var seriesType: String? = null,
    /** Select one or more from: comic, magazine, trade paperback, hardcover, digest, graphic novel, digital comic, infinite comic */
    var contains: String? = null,
    /** Select one or more from: title, modified, startYear, -title, -modified, -startYear */
    var orderBy: String? = null,
    var limit: Int? = null,
    var offset: Int? = null
)