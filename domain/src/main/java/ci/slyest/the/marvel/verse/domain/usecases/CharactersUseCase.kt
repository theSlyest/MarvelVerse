package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.CharacterFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Characters list use case: depends on [CharacterRepository] implementation to perform a request.
 */
class CharactersUseCase : KoinComponent {

    /** Injected [CharacterRepository] */
    private val characterRepository: CharacterRepository by inject()

    /**
     * Perform a request by calling the [CharacterRepository.characters] method.
     * @param characterFilter object carrying the request parameters.
     * @return a [Single]<[DataWrapper]<[Character]>> result object
     */
    operator fun invoke(characterFilter: CharacterFilter): Single<DataWrapper<Character>> =
        characterRepository.characters(characterFilter)
}