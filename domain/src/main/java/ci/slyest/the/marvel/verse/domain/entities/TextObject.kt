package ci.slyest.the.marvel.verse.domain.entities

data class TextObject (
    val type: String, // optional: The canonical type of the text object (e.g. solicit text, preview text, etc.).
    val language: String, // optional: The IETF language tag denoting the language the text object is written in.
    val text: String, // optional: The text.
)