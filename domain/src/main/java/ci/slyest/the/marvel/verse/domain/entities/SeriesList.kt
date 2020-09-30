package ci.slyest.the.marvel.verse.domain.entities

data class SeriesList (
    val available: Int, // optional: The number of total available series in this list. Will always be greater than or equal to the "returned" value.
    val returned: Int, // optional: The number of series returned in this collection (up to 20).
    val collectionURI: String, // optional: The path to the full list of series in this collection.
    val items: List<ResourceSummary> // optional: The list of returned series in this collection.
)