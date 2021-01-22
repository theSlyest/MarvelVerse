package ci.slyest.the.marvel.verse.domain.entities

/**
 * Series class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class Series (
    /** optional: The unique ID of the series resource. */
    val id: Int,
    /** optional: The canonical title of the series. */
    val title: String,
    /** optional: A description of the series. */
    val description: String?,
    /** optional: The canonical URL identifier for this resource. */
    val resourceURI: String,
    /** optional: A set of public web site URLs for the resource. */
    val urls: List<Url>,
    /** optional: The first year of publication for the series. */
    val startYear: Int,
    /** optional: The last year of publication for the series: conventionally, 2099 for ongoing series). */
    val endYear: Int,
    /** optional: The age-appropriateness rating for the series. */
    val rating: String,
    /** optional: The date the resource was most recently modified. */
    val modified: String,
    /** optional: The representative image for this series. */
    val thumbnail: Image,
    /** optional: A resource list containing comics in this series. */
    val comics: ResourceList,
    /** optional: A resource list containing stories which occur in comics in this series. */
    val stories: StoryList,
    /** optional: A resource list containing events which take place in comics in this series. */
    val events: ResourceList,
    /** optional: A resource list containing characters which appear in comics in this series. */
    val characters: ResourceRoleList,
    /** optional: A resource list of creators whose work appears in comics in this series. */
    val creators: ResourceRoleList,
    /** optional: A summary representation of the series which follows this series. */
    val next: ResourceSummary?,
    /** optional: A summary representation of the series which preceded this series. */
    val previous: ResourceSummary?,
)