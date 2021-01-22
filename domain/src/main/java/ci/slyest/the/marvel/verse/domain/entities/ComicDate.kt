package ci.slyest.the.marvel.verse.domain.entities

/**
 * Comic date class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class ComicDate (
    /** optional: A description of the date (e.g. onsale date, FOC date). */
    val type: String,
    /** optional: The date. */
    val date: String,
)