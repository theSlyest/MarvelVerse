package ci.slyest.the.marvel.verse.domain.entities

data class Image (
    val path: String, // optional: The directory path of to the image.
    val extension: String // optional: The file extension for the image.
)