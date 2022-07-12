package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CharacterSource
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.filters.CharacterFilter
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of the [CharacterRepository].
 * @property characterSource [CharacterSource] object
 */
class CharacterRepositoryImpl(private val characterSource: CharacterSource) : CharacterRepository {
    /**
     * Perform a request to get a list of characters by calling [CharacterSource.characters].
     * @param characterFilter Object carrying the request parameters
     * @return a [Single]<[DataWrapper<Character>]> result object
     */
    override fun characters(characterFilter: CharacterFilter): Single<DataWrapper<Character>>
            = characterSource.characters(characterFilter)
}