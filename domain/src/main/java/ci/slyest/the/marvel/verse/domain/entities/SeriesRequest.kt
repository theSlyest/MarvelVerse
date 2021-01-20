package ci.slyest.the.marvel.verse.domain.entities

import java.util.*

class SeriesRequest (
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
    var seriesType: String? = null, // Select one from: collection, one shot, limited, ongoing
    var contains: String? = null, // Select one or more from: comic, magazine, trade paperback, hardcover, digest, graphic novel, digital comic, infinite comic
    var orderBy: String? = null, // Select one or more from: title, modified, startYear, -title, -modified, -startYear
    var limit: Int? = null,
    var offset: Int? = null
)