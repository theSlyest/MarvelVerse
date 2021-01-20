package ci.slyest.the.marvel.verse.domain.entities

data class Event (
    val id: Int, // optional: The unique ID of the event resource.
    val title: String, // optional: The title of the event.
    val description: String, // optional: A description of the event.
    val resourceURI: String, // optional: The canonical URL identifier for this resource.
    val urls: List<Url>, // optional: A set of public web site URLs for the event.
    val modified: String, // optional: The date the resource was most recently modified.
    val start: String?, // optional: The date of publication of the first issue in this event.
    val end: String?, // optional: The date of publication of the last issue in this event.
    val thumbnail: Image, // optional: The representative image for this event.
    val comics: ResourceList, // optional: A resource list containing the comics in this event.
    val stories: StoryList, // optional: A resource list containing the stories in this event.
    val series: ResourceList, // optional: A resource list containing the series in this event.
    val characters: ResourceRoleList, // optional: A resource list containing the characters which appear in this event.
    val creators: ResourceRoleList, // optional: A resource list containing creators whose work appears in this event.
    val next: ResourceSummary?, // optional: A summary representation of the event which follows this event.
    val previous: ResourceSummary? // optional: A summary representation of the event which preceded this event.
)