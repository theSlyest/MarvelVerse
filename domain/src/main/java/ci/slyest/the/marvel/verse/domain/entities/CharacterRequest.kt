package ci.slyest.the.marvel.verse.domain.entities

import java.util.*

class CharacterRequest (
    var comicId: Int? = null,
    var eventId: Int? = null,
    var seriesId: Int? = null,
    var storyId: Int? = null,
    var name: String? = null,
    var nameStartsWith: String? = null,
    var modifiedSince: Date? = null,
    var comics: String? = null,
    var series: String? = null,
    var events: String? = null,
    var stories: String? = null,
    var orderBy: String? = null,
    var limit: Int? = null,
    var offset: Int? = null
)