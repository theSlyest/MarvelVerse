package ci.slyest.the.marvel.verse.domain.entities

data class Story (
    val id: Int, // optional: The unique ID of the story resource.
    val title: String, // optional: The story title.
    val description: String, // optional: A short description of the story.
    val resourceURI: String, // optional: The canonical URL identifier for this resource. ,
    val type: String, // optional: The story type e.g. interior story, cover, text story.
    val modified: String, // optional: The date the resource was most recently modified.
    val thumbnail: Image, // optional: The representative image for this story.
    val comics: ComicList, // optional: A resource list containing comics in which this story takes place.
    val series: ResourceList, // optional: A resource list containing series in which this story appears.
    val events: EventList, // optional: A resource list of the events in which this story appears.
    val characters: ResourceList, // optional: A resource list of characters which appear in this story.
    val creators: ResourceList, // optional: A resource list of creators who worked on this story.
    val originalissue: ResourceSummary, // optional: A summary representation of the issue in which this story was originally published.
)