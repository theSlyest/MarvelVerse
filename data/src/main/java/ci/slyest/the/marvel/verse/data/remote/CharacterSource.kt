package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.CharacterFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import io.reactivex.rxjava3.core.Single

/**
 * Source class for character requests. Implements [IMarvelSource].
 * @property characterService Required [CharacterService].
 */
class CharacterSource(private val characterService: CharacterService) : IMarvelSource() {

    /**
     * Perform the right characters request according to the given parameters.
     * @param filter [CharacterFilter] object carrying the request parameters.
     * @return [Single]<[DataWrapper]<[Character]>> request result.
     */
    fun characters(filter: CharacterFilter): Single<DataWrapper<Character>> {
        val ts = getTimestamp()
        return when {
            filter.comicId != null ->
                characterService.comicCharacters(filter.comicId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.series,
                    filter.events, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.eventId != null ->
                characterService.eventCharacters(filter.eventId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.comics,
                    filter.series, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.seriesId != null ->
                characterService.seriesCharacters(filter.seriesId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.comics,
                    filter.events, filter.stories, filter.orderBy, filter.limit, filter.offset)
            filter.storyId != null ->
                characterService.storyCharacters(filter.storyId!!, PUBLIC_KEY, ts, getHash(ts),
                    filter.name, filter.nameStartsWith, formatDate(filter.modifiedSince), filter.comics,
                    filter.series, filter.events, filter.orderBy, filter.limit, filter.offset)
            else ->
                characterService.characters(PUBLIC_KEY, ts, getHash(ts), filter.name, filter.nameStartsWith,
                    formatDate(filter.modifiedSince), filter.comics, filter.series, filter.events, filter.stories,
                    filter.orderBy, filter.limit, filter.offset)
        }
    }

//    fun characterById(id: Int): Single<DataWrapper<Character>> {
//        val ts = getTimestamp()
//        val hash = getHash(ts)
//        return marvelService.characterById(id, PUBLIC_KEY, ts, hash)
//    }
}