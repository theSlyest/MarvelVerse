package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import io.reactivex.rxjava3.core.Single
import java.text.SimpleDateFormat
import java.util.*

class CharacterSource(private val characterService: CharacterService) : IMarvelSource() {

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
        return characterService.characters(
            PUBLIC_KEY, ts, getHash(ts), name, nameStartsWith, formatDate(modifiedSince),
            comics, series, events, stories, orderBy, limit, offset)
    }

    fun comicCharacters(
        comicId: Int,
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
        return characterService.comicCharacters(
            comicId, PUBLIC_KEY, ts, getHash(ts), name, nameStartsWith, formatDate(modifiedSince),
            comics, series, events, stories, orderBy, limit, offset)
    }

    fun eventCharacters(
        eventId: Int,
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
        return characterService.eventCharacters(
            eventId, PUBLIC_KEY, ts, getHash(ts), name, nameStartsWith, formatDate(modifiedSince),
            comics, series, events, stories, orderBy, limit, offset)
    }

    fun seriesCharacters(
        seriesId: Int,
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
        return characterService.seriesCharacters(
            seriesId, PUBLIC_KEY, ts, getHash(ts), name, nameStartsWith, formatDate(modifiedSince),
            comics, series, events, stories, orderBy, limit, offset)
    }

    fun storyCharacters(
        storyId: Int,
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
        return characterService.storyCharacters(
            storyId, PUBLIC_KEY, ts, getHash(ts), name, nameStartsWith, formatDate(modifiedSince),
            comics, series, events, stories, orderBy, limit, offset)
    }

//    fun characterById(id: Int): Single<CharacterDataWrapper> {
//        val ts = getTimestamp()
//        val hash = getHash(ts)
//        return marvelService.characterById(id, PUBLIC_KEY, ts, hash)
//    }
}