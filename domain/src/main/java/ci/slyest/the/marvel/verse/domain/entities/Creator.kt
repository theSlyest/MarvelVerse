package ci.slyest.the.marvel.verse.domain.entities

data class Creator (
    val id: Int, // optional: The unique ID of the creator resource.
    val firstName: String, // optional: The first name of the creator.
    val middleName: String, // optional: The middle name of the creator.
    val lastName: String, // optional: The last name of the creator.
    val suffix: String, // optional: The suffix or honorific for the creator.
    val fullName: String, // optional: The full name of the creator: a space-separated concatenation of the above four fields).
    val modified: String, // optional: The date the resource was most recently modified.
    val resourceURI: String, // optional: The canonical URL identifier for this resource.
    val urls: List<Url>, // optional: A set of public web site URLs for the resource.
    val thumbnail: Image, // optional: The representative image for this creator.
    val series: ResourceList, // optional: A resource list containing the series which feature work by this creator.
    val stories: StoryList, // optional: A resource list containing the stories which feature work by this creator.
    val comics: ResourceList, // optional: A resource list containing the comics which feature work by this creator.
    val events: ResourceList, // optional: A resource list containing the events which feature work by this creator.
)