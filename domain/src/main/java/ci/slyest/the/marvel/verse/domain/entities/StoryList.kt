package ci.slyest.the.marvel.verse.domain.entities

data class StoryList (
    val available: Int, // optional: The number of total available stories in this list. Will always be greater than or equal to the "returned" value.
    val returned: Int, // optional: The number of stories returned in this collection (up to 20).
    val collectionURI: String, // optional: The path to the full list of stories in this collection.
    val items: List<StorySummary> // optional: The list of returned stories in this collection.
)