package ci.slyest.the.marvel.verse.domain.entities

data class ComicDate (
    val type: String, // optional: A description of the date (e.g. onsale date, FOC date).
    val date: String, // optional: The date.
)