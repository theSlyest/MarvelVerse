package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import io.reactivex.rxjava3.core.Single
import java.text.SimpleDateFormat
import java.util.*

class CharacterSource(private val characterService: CharacterService) : IMarvelSource() {

    fun characters(req: CharacterRequest): Single<CharacterDataWrapper> {
        val ts = getTimestamp()
        return when {
            req.comicId != null ->
                characterService.comicCharacters(req.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.series,
                    req.events, req.stories, req.orderBy, req.limit, req.offset)
            req.eventId != null ->
                characterService.eventCharacters(req.eventId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.comics,
                    req.series, req.stories, req.orderBy, req.limit, req.offset)
            req.seriesId != null ->
                characterService.seriesCharacters(req.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.comics,
                    req.events, req.stories, req.orderBy, req.limit, req.offset)
            req.storyId != null ->
                characterService.storyCharacters(req.storyId!!, PUBLIC_KEY, ts, getHash(ts),
                    req.name, req.nameStartsWith, formatDate(req.modifiedSince), req.comics,
                    req.series, req.events, req.orderBy, req.limit, req.offset)
            else ->
                characterService.characters(PUBLIC_KEY, ts, getHash(ts), req.name, req.nameStartsWith,
                    formatDate(req.modifiedSince), req.comics, req.series, req.events, req.stories,
                    req.orderBy, req.limit, req.offset)
        }
    }

//    fun characterById(id: Int): Single<CharacterDataWrapper> {
//        val ts = getTimestamp()
//        val hash = getHash(ts)
//        return marvelService.characterById(id, PUBLIC_KEY, ts, hash)
//    }
}