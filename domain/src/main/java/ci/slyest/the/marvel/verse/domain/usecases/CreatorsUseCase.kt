package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CreatorRequest
import ci.slyest.the.marvel.verse.domain.repositories.CreatorRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class CreatorsUseCase : KoinComponent {

    private val creatorRepository: CreatorRepository by inject()

    operator fun invoke(creatorRequest: CreatorRequest): Single<CreatorDataWrapper> =
        creatorRepository.creators(creatorRequest)
}