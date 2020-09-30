package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CharacterSource
import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
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

    override fun characterById(id: Int): Single<CharacterDataWrapper>
            = characterSource.characterById(id)
}