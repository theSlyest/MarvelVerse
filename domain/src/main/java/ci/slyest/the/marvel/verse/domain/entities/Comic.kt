package ci.slyest.the.marvel.verse.domain.entities

/**
 * Comic class
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
data class Comic(
    /** optional: The unique ID of the comic resource. */
    val id: Int,
    /** optional: The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally. */
    val digitalId: Int,
    /** optional: The canonical title of the comic. */
    val title: String,
    /** optional: The number of the issue in the series: will generally be 0 for collection formats). */
    val issueNumber: Double,
    /** optional: If the issue is a variant: e.g. an alternate cover, second printing, or director’s cut), a text description of the variant. */
    val variantDescription: String,
    /** optional: The preferred description of the comic. */
    val description: String?,
    /** optional: The date the resource was most recently modified. */
    val modified: String,
    /** optional: The ISBN for the comic: generally only populated for collection formats). */
    val isbn: String,
    /** optional: The UPC barcode number for the comic: generally only populated for periodical formats). */
    val upc: String,
    /** optional: The Diamond code for the comic. */
    val diamondCode: String,
    /** optional: The EAN barcode for the comic. */
    val ean: String,
    /** optional: The ISSN barcode for the comic. */
    val issn: String,
    /** optional: The publication format of the comic e.g. comic, hardcover, trade paperback. */
    val format: String,
    /** optional: The number of story pages in the comic. */
    val pageCount: Int,
    /** optional: A set of descriptive text blurbs for the comic. */
    val textObjects: List<TextObject>,
    /** optional: The canonical URL identifier for this resource. */
    val resourceURI: String,
    /** optional: A set of public web site URLs for the resource. */
    val urls: List<Url>,
    /** optional: A summary representation of the series to which this comic belongs. */
    val series: ResourceSummary,
    /** optional: A list of variant issues for this comic: includes the "original" issue if the current issue is a variant). */
    val variants: List<ResourceSummary>,
    /** optional: A list of collections which include this comic: will generally be empty if the comic's format is a collection). */
    val collections: List<ResourceSummary>,
    /** optional: A list of issues collected in this comic: will generally be empty for periodical formats such as "comic" or "magazine"). */
    val collectedIssues: List<ResourceSummary>,
    /** optional: A list of key dates for this comic. */
    val dates: List<ComicDate>,
    /** optional: A list of prices for this comic. */
    val prices: List<ComicPrice>,
    /** optional: The representative image for this comic. */
    val thumbnail: Image,
    /** optional: A list of promotional images associated with this comic. */
    val images: List<Image>,
    /** optional: A resource list containing the creators associated with this comic. */
    val creators: ResourceRoleList,
    /** optional: A resource list containing the characters which appear in this comic. */
    val characters: ResourceRoleList,
    /** optional: A resource list containing the stories which appear in this comic. */
    val stories: StoryList,
    /** optional: A resource list containing the events in which this comic appears. */
    val events: ResourceList
)