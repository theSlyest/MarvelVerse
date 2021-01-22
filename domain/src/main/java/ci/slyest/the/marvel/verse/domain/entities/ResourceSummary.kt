package ci.slyest.the.marvel.verse.domain.entities

/**
 * Resource summary class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class ResourceSummary (
    /** optional: The path to the individual comic resource. */
    val resourceURI: String,
    /** optional: The canonical name of the comic. */
    val name: String
)