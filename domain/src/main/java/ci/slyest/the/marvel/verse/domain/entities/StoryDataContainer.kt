package ci.slyest.the.marvel.verse.domain.entities

data class StoryDataContainer (
    val offset: Int, // optional: The requested offset (number of skipped results) of the call.
    val limit: Int, // optional: The requested result limit.
    val total: Int, // optional: The total number of resources available given the current filter set.
    val count: Int, // optional: The total number of results returned by this call.
    val results: List<Story> // optional: The list of stories returned by the call.
)