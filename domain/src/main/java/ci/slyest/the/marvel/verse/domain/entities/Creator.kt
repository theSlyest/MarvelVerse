package ci.slyest.the.marvel.verse.domain.entities

/**
 * Creator class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class Creator (
    /** optional: The unique ID of the creator resource. */
    val id: Int,
    /** optional: The first name of the creator. */
    val firstName: String,
    /** optional: The middle name of the creator. */
    val middleName: String,
    /** optional: The last name of the creator. */
    val lastName: String,
    /** optional: The suffix or honorific for the creator. */
    val suffix: String,
    /** optional: The full name of the creator: a space-separated concatenation of the above four fields). */
    val fullName: String,
    /** optional: The date the resource was most recently modified. */
    val modified: String,
    /** optional: The canonical URL identifier for this resource. */
    val resourceURI: String,
    /** optional: A set of public web site URLs for the resource. */
    val urls: List<Url>,
    /** optional: The representative image for this creator. */
    val thumbnail: Image,
    /** optional: A resource list containing the series which feature work by this creator. */
    val series: ResourceList,
    /** optional: A resource list containing the stories which feature work by this creator. */
    val stories: StoryList,
    /** optional: A resource list containing the comics which feature work by this creator. */
    val comics: ResourceList,
    /** optional: A resource list containing the events which feature work by this creator. */
    val events: ResourceList,
)