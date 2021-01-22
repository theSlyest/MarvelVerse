package ci.slyest.the.marvel.verse.presentation.common

import ci.slyest.the.marvel.verse.domain.entities.*
import java.lang.ref.WeakReference

/** Used to retain a resource object when moving from a list screen to a detail screen. */
object ResourceHolder {

    /** Map used to store the retained objects */
    private var data: MutableMap<String, WeakReference<Any>> = HashMap()

    /**
     * Insert an object in [data] with the given [key].
     * @param key [String] the key.
     * @param any the object to retain.
     */
    private fun putData(key: String, any: Any?) {
        data[key] = WeakReference<Any>(any)
    }

    /**
     * Get an object from [data] corresponding to the given [key].
     * @param key [String] Key of the retained object.
     */
    private fun getData(key: String): Any? = data[key]?.get()

    /**
     * Retain the given [Character] object.
     * @param character a [Character] object.
     */
    fun putCharacter(character: Character) = putData(ResourceType.CHARACTER.name, character)

    /**
     * Get the retained [Character] object.
     * @return a [Character] object previously retained.
     */
    fun getCharacter(): Character = getData(ResourceType.CHARACTER.name) as Character

    /**
     * Retain the given [Comic] object.
     * @param comic a [Comic] object.
     */
    fun putComic(comic: Comic) = putData(ResourceType.COMIC.name, comic)

    /**
     * Get the retained [Comic] object.
     * @return a [Comic] object previously retained.
     */
    fun getComic(): Comic = getData(ResourceType.COMIC.name) as Comic

    /**
     * Retain the given [Creator] object.
     * @param creator a [Creator] object.
     */
    fun putCreator(creator: Creator) = putData(ResourceType.CREATOR.name, creator)

    /**
     * Get the retained [Creator] object.
     * @return a [Creator] object previously retained.
     */
    fun getCreator(): Creator = getData(ResourceType.CREATOR.name) as Creator

    /**
     * Retain the given [Event] object.
     * @param event a [Event] object.
     */
    fun putEvent(event: Event) = putData(ResourceType.EVENT.name, event)

    /**
     * Get the retained [Event] object.
     * @return a [Event] object previously retained.
     */
    fun getEvent(): Event = getData(ResourceType.EVENT.name) as Event

    /**
     * Retain the given [Series] object.
     * @param series a [Series] object.
     */
    fun putSeries(series: Series) = putData(ResourceType.SERIES.name, series)

    /**
     * Get the retained [Series] object.
     * @return a [Series] object previously retained.
     */
    fun getSeries(): Series = getData(ResourceType.SERIES.name) as Series

    /**
     * Retain the given [Story] object.
     * @param story a [Story] object.
     */
    fun putStory(story: Story) = putData(ResourceType.STORY.name, story)

    /**
     * Get the retained [Story] object.
     * @return a [Story] object previously retained.
     */
    fun getStory(): Story = getData(ResourceType.STORY.name) as Story
}