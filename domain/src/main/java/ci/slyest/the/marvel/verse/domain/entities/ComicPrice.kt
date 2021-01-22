package ci.slyest.the.marvel.verse.domain.entities

/**
 * Comic price class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class ComicPrice (
    /** optional:  A description of the price (e.g. print price, digital price). */
    val type: String,
    /** optional: The price (all prices in USD). */
    val price: Float
)