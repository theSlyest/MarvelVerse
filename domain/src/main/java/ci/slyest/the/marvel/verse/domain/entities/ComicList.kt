package ci.slyest.the.marvel.verse.domain.entities

data class ComicList (
    val available: Int, // optional: The number of total available issues in this list. Will always be greater than or equal to the "returned" value.
    val returned: Int, // optional: The number of issues returned in this collection (up to 20).
    val collectionURI: String, // optional: The path to the full list of issues in this collection.
    val items: List<ResourceSummary> // optional: The list of returned issues in this collection.
)