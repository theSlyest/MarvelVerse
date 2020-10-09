package ci.slyest.the.marvel.verse.domain.entities

import java.util.*

class StoryRequest (
    var characterId: Int? = null,
    var comicId: Int? = null,
    var eventId: Int? = null,
    var seriesId: Int? = null,
    var creatorId: Int? = null,
    var modifiedSince: Date? = null,
    var comics: String? = null,
    var series: String? = null,
    var events: String? = null,
    var creators: String? = null,
    var characters: String? = null,
    var orderBy: String? = null,
    var limit: Int? = null,
    var offset: Int? = null
)