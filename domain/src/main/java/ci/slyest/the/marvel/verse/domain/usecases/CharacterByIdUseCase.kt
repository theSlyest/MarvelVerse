package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharacterByIdUseCase  : KoinComponent {

    private val characterRepository: CharacterRepository by inject()

//    operator fun invoke(id: Int): Single<DataWrapper<Character>>
//            = characterRepository.characterById(id)
}