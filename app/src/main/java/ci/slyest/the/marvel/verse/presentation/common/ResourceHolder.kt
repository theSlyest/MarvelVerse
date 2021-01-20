package ci.slyest.the.marvel.verse.presentation.common

import ci.slyest.the.marvel.verse.domain.entities.*
import java.lang.ref.WeakReference

object ResourceHolder {

    private var data: MutableMap<String, WeakReference<Any>> = HashMap()

    private fun putData(id: String, any: Any?) {
        data[id] = WeakReference<Any>(any)
    }

    private fun getData(id: String): Any? = data[id]?.get()

    fun putCharacter(character: Character) = putData(ResourceType.CHARACTER.name, character)

    fun getCharacter(): Character = getData(ResourceType.CHARACTER.name) as Character

    fun putComic(comic: Comic) = putData(ResourceType.COMIC.name, comic)

    fun getComic(): Comic = getData(ResourceType.COMIC.name) as Comic

    fun putCreator(creator: Creator) = putData(ResourceType.CREATOR.name, creator)

    fun getCreator(): Creator = getData(ResourceType.CREATOR.name) as Creator

    fun putEvent(event: Event) = putData(ResourceType.EVENT.name, event)

    fun getEvent(): Event = getData(ResourceType.EVENT.name) as Event

    fun putSeries(series: Series) = putData(ResourceType.SERIES.name, series)

    fun getSeries(): Series = getData(ResourceType.SERIES.name) as Series

    fun putStory(story: Story) = putData(ResourceType.STORY.name, story)

    fun getStory(): Story = getData(ResourceType.STORY.name) as Story
}