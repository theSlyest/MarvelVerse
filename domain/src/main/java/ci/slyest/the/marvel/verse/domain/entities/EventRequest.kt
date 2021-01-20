package ci.slyest.the.marvel.verse.domain.entities

import java.util.*

class EventRequest (
    var characterId: Int? = null,
    var comicId: Int? = null,
    var creatorId: Int? = null,
    var seriesId: Int? = null,
    var storyId: Int? = null,
    var name: String? = null,
    var nameStartsWith: String? = null,
    var modifiedSince: Date? = null,
    var creators: String? = null,
    var characters: String? = null,
    var series: String? = null,
    var comics: String? = null,
    var stories: String? = null,
    var orderBy: String? = null, // Select one or more from: name, startDate, modified (add a "-" to the value sort in descending order)
    var limit: Int? = null,
    var offset: Int? = null
)