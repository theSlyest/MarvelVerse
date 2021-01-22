package ci.slyest.the.marvel.verse.domain.entities

/**
 * text object class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class TextObject (
    /** optional: The canonical type of the text object (e.g. solicit text, preview text, etc.). */
    val type: String,
    /** optional: The IETF language tag denoting the language the text object is written in. */
    val language: String,
    /** optional: The text. */
    val text: String,
)