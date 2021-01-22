package ci.slyest.the.marvel.verse.domain.entities

/**
 * Story list class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class StoryList (
    /** optional: The number of total available stories in this list. Will always be greater than or equal to the "returned" value. */
    val available: Int,
    /** optional: The number of stories returned in this collection (up to 20). */
    val returned: Int,
    /** optional: The path to the full list of stories in this collection. */
    val collectionURI: String,
    /** optional: The list of returned stories in this collection. */
    val items: List<StorySummary>
)