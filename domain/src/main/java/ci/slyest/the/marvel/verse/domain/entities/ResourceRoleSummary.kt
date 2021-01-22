package ci.slyest.the.marvel.verse.domain.entities

/**
 * Resource (with role) summary class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class ResourceRoleSummary (
    /** optional: The path to the individual resource. */
    val resourceURI: String,
    /** optional: The canonical name of the resource. */
    val name: String,
    /** optional: The role of the creator in the parent entity. */
    val role: String
)