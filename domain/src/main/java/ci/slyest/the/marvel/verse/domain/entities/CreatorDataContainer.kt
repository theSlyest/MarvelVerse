package ci.slyest.the.marvel.verse.domain.entities

/**
 * Creator data container class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class CreatorDataContainer (
    /** optional: The requested offset: number of skipped results) of the call. */
    val offset: Int,
    /** optional: The requested result limit. */
    val limit: Int,
    /** optional: The total number of resources available given the current filter set. */
    val total: Int,
    /** optional: The total number of results returned by this call. */
    val count: Int,
    /** optional: The list of creators returned by the call. */
    val results: List<Creator>
)