package ci.slyest.the.marvel.verse.domain.entities

data class Url (
    val type: String, // optional: A text identifier for the URL.
    val url: String // optional: A full URL (including scheme, domain, and path).
)