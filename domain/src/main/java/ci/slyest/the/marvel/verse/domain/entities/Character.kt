package ci.slyest.the.marvel.verse.domain.entities

/**
 * Character resource class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class Character (
    /** optional: The unique ID of the character resource. */
    val id: Int,
    /** optional: The name of the character. */
    val name: String,
    /** optional: A short bio or description of the character. */
    val description: String,
    /** optional: The date the resource was most recently modified. */
    val modified: String,
    /** optional: The canonical URL identifier for this resource. */
    val resourceURI: String,
    /** optional: A set of public web site URLs for the resource. */
    val urls: List<Url>,
    /** optional: The representative image for this character. */
    val thumbnail: Image,
    /** optional: A resource list containing comics which feature this character. */
    val comics: ResourceList,
    /** optional: A resource list of stories in which this character appears. */
    val stories: StoryList,
    /** optional: A resource list of events in which this character appears. */
    val events: ResourceList,
    /** optional: A resource list of series in which this character appears. */
    val series: ResourceList
)