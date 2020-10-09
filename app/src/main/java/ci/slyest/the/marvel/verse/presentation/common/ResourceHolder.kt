package ci.slyest.the.marvel.verse.presentation.common

import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.Comic
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
}