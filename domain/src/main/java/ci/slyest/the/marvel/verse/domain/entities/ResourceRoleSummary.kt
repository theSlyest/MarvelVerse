package ci.slyest.the.marvel.verse.domain.entities

data class ResourceRoleSummary (
    val resourceURI: String, // optional: The path to the individual resource.
    val name: String, // optional: The canonical name of the resource.
    val role: String // optional: The role of the creator in the parent entity.
)