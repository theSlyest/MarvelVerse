package ci.slyest.the.marvel.verse.domain.entities

import java.util.*

class CreatorRequest (
    var comicId: Int? = null,
    var eventId: Int? = null,
    var seriesId: Int? = null,
    var storyId: Int? = null,
    var firstName: String? = null,
    var middleName: String? = null,
    var lastName: String? = null,
    var suffix: String? = null,
    var firstNameStartsWith: String? = null,
    var middleNameStartsWith: String? = null,
    var lastNameStartsWith: String? = null,
    var modifiedSince: Date? = null,
    var comics: String? = null,
    var series: String? = null,
    var events: String? = null,
    var stories: String? = null,
    var orderBy: String? = null, // Select one or more from: lastName, firstName, middleName, suffix, modified (add a "-" to the value sort in descending order)
    var limit: Int? = null,
    var offset: Int? = null
)