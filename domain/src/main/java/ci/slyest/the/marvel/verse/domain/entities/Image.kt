package ci.slyest.the.marvel.verse.domain.entities

/**
 * Image class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class Image (
    /** optional: The directory path of to the image. */
    val path: String,
    /** optional: The file extension for the image. */
    val extension: String
)