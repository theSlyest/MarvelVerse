package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CharacterSource
import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single
import java.util.*

class CharacterRepositoryImpl(private val characterSource: CharacterSource) : CharacterRepository {

    override fun characters(
        name: String?,
        nameStartsWith: String?,
        modifiedSince: Date?,
        comics: String?,
        series: String?,
        events: String?,
        stories: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): Single<CharacterDataWrapper>
            = characterSource.characters(name, nameStartsWith, modifiedSince, comics, series, events,
        stories, orderBy, limit, offset)

    override fun comicCharacters(
        comicId: Int,
        name: String?,
        nameStartsWith: String?,
        modifiedSince: Date?,
        series: String?,
        events: String?,
        stories: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): Single<CharacterDataWrapper>
            = characterSource.comicCharacters(comicId, name, nameStartsWith, modifiedSince, series,
        events, stories, orderBy, limit, offset)

    override fun eventCharacters(
        eventId: Int,
        name: String?,
        nameStartsWith: String?,
        modifiedSince: Date?,
        comics: String?,
        series: String?,
        stories: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): Single<CharacterDataWrapper>
            = characterSource.eventCharacters(eventId, name, nameStartsWith, modifiedSince, comics,
        series, stories, orderBy, limit, offset)

    override fun seriesCharacters(
        seriesId: Int,
        name: String?,
        nameStartsWith: String?,
        modifiedSince: Date?,
        comics: String?,
        events: String?,
        stories: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): Single<CharacterDataWrapper>
            = characterSource.seriesCharacters(seriesId, name, nameStartsWith, modifiedSince, comics,
        events, stories, orderBy, limit, offset)

    override fun storyCharacters(
        storyId: Int,
        name: String?,
        nameStartsWith: String?,
        modifiedSince: Date?,
        comics: String?,
        series: String?,
        events: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): Single<CharacterDataWrapper>
            = characterSource.storyCharacters(storyId, name, nameStartsWith, modifiedSince, comics,
        series, events, orderBy, limit, offset)
}