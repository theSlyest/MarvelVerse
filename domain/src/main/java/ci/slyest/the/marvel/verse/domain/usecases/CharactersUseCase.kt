package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
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
     * @param characterRequest object carrying the request parameters.
     * @return a [Single]<[CharacterDataWrapper]> result object
     */
    operator fun invoke(characterRequest: CharacterRequest): Single<CharacterDataWrapper> =
        characterRepository.characters(characterRequest)
}