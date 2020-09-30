package ci.slyest.the.marvel.verse.domain.entities

data class StorySummary (
    val resourceURI: String, // optional: The path to the individual story resource.
    val name: String, // optional: The canonical name of the story.
    val type: String // optional: The type of the story (interior or cover).
)