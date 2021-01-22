package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import io.reactivex.rxjava3.core.Single

/** Character repository interface to be implemented in the data module. */
interface CharacterRepository {

    /**
     * Perform a request to get a list of characters
     * @param characterRequest Object carrying the request parameters
     * @return a [Single]<[CharacterDataWrapper]> result object
     */
    fun characters(characterRequest: CharacterRequest): Single<CharacterDataWrapper>

//    fun characterById(id: Int): Single<CharacterDataWrapper>
}