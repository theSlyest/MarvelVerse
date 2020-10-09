package ci.slyest.the.marvel.verse.domain.entities

data class ComicDataWrapper(
    val code: Int, // optional: The HTTP status code of the returned result.
    val status: String, // optional: A string description of the call status.
    val copyright: String, // optional: The copyright notice for the returned result.
    val attributionText: String, // optional: The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.
    val attributionHTML: String, // optional: An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.
    val data: ComicDataContainer, // optional: The results returned by the call.
    val etag: String // optional: A digest value of the content returned by the call.
)