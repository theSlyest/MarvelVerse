package ci.slyest.the.marvel.verse.domain.entities

/**
 * Character data wrapper class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class DataWrapper<T> (
    /** optional: The HTTP status code of the returned result. */
    val code: Int,
    /** optional: A string description of the call status. */
    val status: String,
    /** optional: The copyright notice for the returned result. */
    val copyright: String,
    /** optional: The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API. */
    val attributionText: String,
    /** optional: An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API. */
    val attributionHTML: String,
    /** optional: The results returned by the call. */
    val data: DataContainer<T>,
    /** optional e-Tag */
    val etag: String
)