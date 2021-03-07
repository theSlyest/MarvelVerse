package ci.slyest.the.marvel.verse.domain.entities

import java.util.Date

/**
 * Request filter class to carry the request parameters.
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
open class BaseFilter (
    var modifiedSince: Date? = null,
    var orderBy: String? = null, // Select one, add a "-" to the value sort in descending order
    var limit: Int? = null,
    var offset: Int? = null
)