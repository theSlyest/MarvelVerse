package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CharacterSource
import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of the [CharacterRepository].
 * @property characterSource [CharacterSource] object
 */
class CharacterRepositoryImpl(private val characterSource: CharacterSource) : CharacterRepository {
    /**
     * Perform a request to get a list of characters by calling [CharacterSource.characters].
     * @param characterRequest Object carrying the request parameters
     * @return a [Single]<[CharacterDataWrapper]> result object
     */
    override fun characters(characterRequest: CharacterRequest): Single<CharacterDataWrapper>
            = characterSource.characters(characterRequest)
}