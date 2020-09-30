package ci.slyest.the.marvel.verse.domain.entities

data class Character (
    val id: Int, // optional: The unique ID of the character resource.
    val name: String, // optional: The name of the character.
    val description: String, // optional: A short bio or description of the character.
    val modified: String, // optional: The date the resource was most recently modified.
    val resourceURI: String, // optional: The canonical URL identifier for this resource.
    val urls: List<Url>, // optional: A set of public web site URLs for the resource.,
    val thumbnail: Image, // optional: The representative image for this character.,
    val comics: ComicList, // optional: A resource list containing comics which feature this character.,
    val stories: StoryList, // optional: A resource list of stories in which this character appears.,
    val events: EventList, // optional: A resource list of events in which this character appears.,
    val series: ResourceList // optional: A resource list of series in which this character appears.
)