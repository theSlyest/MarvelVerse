package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import io.reactivex.rxjava3.core.Single
import java.text.SimpleDateFormat
import java.util.*

class CharacterSource(private val marvelService: MarvelService) : IMarvelSource() {

    fun characters(
        name: String? = null,
        nameStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: String? = null,
        series: String? = null,
        events: String? = null,
        stories: String? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<CharacterDataWrapper> {
        val ts = getTimestamp()
        val hash = getHash(ts)
        val since: String? = modifiedSince?.run {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this)
        }
        return marvelService.characters(
            PUBLIC_KEY, ts, hash, name, nameStartsWith, since,
            comics, series, events, stories, orderBy, limit, offset)
    }

//    fun characterById(id: Int): Single<CharacterDataWrapper> {
//        val ts = getTimestamp()
//        val hash = getHash(ts)
//        return marvelService.characterById(id, PUBLIC_KEY, ts, hash)
//    }
}