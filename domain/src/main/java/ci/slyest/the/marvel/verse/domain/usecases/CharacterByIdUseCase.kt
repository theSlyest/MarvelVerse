package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class CharacterByIdUseCase  : KoinComponent {

    private val characterRepository: CharacterRepository by inject()

//    operator fun invoke(id: Int): Single<CharacterDataWrapper>
//            = characterRepository.characterById(id)
}