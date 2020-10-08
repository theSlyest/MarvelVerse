package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CharacterSource
import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single

class CharacterRepositoryImpl(private val characterSource: CharacterSource) : CharacterRepository {

    override fun characters(characterRequest: CharacterRequest): Single<CharacterDataWrapper>
            = characterSource.characters(characterRequest)
}