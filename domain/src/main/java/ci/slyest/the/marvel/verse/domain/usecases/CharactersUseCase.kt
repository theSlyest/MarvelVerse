package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

class CharactersUseCase : KoinComponent {

    private val characterRepository: CharacterRepository by inject()

    operator fun invoke(characterRequest: CharacterRequest): Single<CharacterDataWrapper> =
        characterRepository.characters(characterRequest)
}