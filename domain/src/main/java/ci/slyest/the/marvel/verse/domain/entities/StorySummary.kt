package ci.slyest.the.marvel.verse.domain.entities

/**
 * Story summary class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class StorySummary (
    /** optional: The path to the individual story resource. */
    val resourceURI: String,
    /** optional: The canonical name of the story. */
    val name: String,
    /** optional: The type of the story (interior or cover). */
    val type: String
)