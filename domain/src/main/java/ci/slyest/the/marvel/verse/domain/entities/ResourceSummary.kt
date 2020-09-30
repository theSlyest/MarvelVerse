package ci.slyest.the.marvel.verse.domain.entities

data class ResourceSummary (
    val resourceURI: String, // optional: The path to the individual comic resource.
    val name: String // optional: The canonical name of the comic.
)