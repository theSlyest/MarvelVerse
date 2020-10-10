package ci.slyest.the.marvel.verse.domain.entities

data class SeriesDataContainer (
    val offset: Int, // optional: The requested offset (number of skipped results) of the call.
    val limit: Int, // optional: The requested result limit.
    val total: Int, // optional: The total number of resources available given the current filter set.
    val count: Int, // optional: The total number of results returned by this call.
    val results: List<Series> // optional: The list of series returned by the call.
)