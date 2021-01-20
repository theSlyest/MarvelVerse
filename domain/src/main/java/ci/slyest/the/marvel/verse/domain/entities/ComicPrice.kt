package ci.slyest.the.marvel.verse.domain.entities

data class ComicPrice (
    val type: String, // optional:  A description of the price (e.g. print price, digital price).
    val price: Float // optional: The price (all prices in USD).
)