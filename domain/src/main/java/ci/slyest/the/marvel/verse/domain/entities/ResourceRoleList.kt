package ci.slyest.the.marvel.verse.domain.entities

data class ResourceRoleList (
    val available: Int, // optional: The number of total available resources in this list. Will always be greater than or equal to the "returned" value.
    val returned: Int, // optional: The number of resources returned in this collection (up to 20).
    val collectionURI: String, // optional: The path to the full list of resources in this collection.
    val items: List<ResourceRoleSummary> // optional: The list of returned resources in this collection.
)