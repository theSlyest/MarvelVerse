package ci.slyest.the.marvel.verse.domain.entities

/**
 * Resource (with role) list class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class ResourceRoleList (
    /** optional: The number of total available resources in this list. Will always be greater than or equal to the "returned" value. */
    val available: Int,
    /** optional: The number of resources returned in this collection (up to 20). */
    val returned: Int,
    /** optional: The path to the full list of resources in this collection. */
    val collectionURI: String,
    /** optional: The list of returned resources in this collection. */
    val items: List<ResourceRoleSummary>
)