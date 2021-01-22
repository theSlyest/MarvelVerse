package ci.slyest.the.marvel.verse.domain.entities

/**
 * URL class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class Url (
    /** optional: A text identifier for the URL. */
    val type: String,
    /** optional: A full URL (including scheme, domain, and path). */
    val url: String
)