package ci.slyest.the.marvel.verse.domain.entities

data class ComicDataContainer (
    val offset: Int, // optional: The requested offset (number of skipped results) of the call.,
    val limit: Int, // optional: The requested result limit.,
    val total: Int, // optional: The total number of resources available given the current filter set.,
    val count: Int, // optional: The total number of results returned by this call.,
    val results: List<Comic> // optional: The list of comics returned by the call
)