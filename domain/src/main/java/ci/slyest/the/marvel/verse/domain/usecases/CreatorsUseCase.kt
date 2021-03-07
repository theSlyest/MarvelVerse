package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.domain.entities.CreatorFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.CreatorRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Creators list use case: depends on [CreatorRepository] implementation to perform a request.
 */
class CreatorsUseCase : KoinComponent {

    /** Injected [CreatorRepository] */
    private val creatorRepository: CreatorRepository by inject()

    /**
     * Perform a request by calling the [CreatorRepository.creators] method.
     * @param creatorFilter object carrying the request parameters.
     * @return a [Single]<[DataWrapper]<[Creator]>> result object
     */
    operator fun invoke(creatorFilter: CreatorFilter): Single<DataWrapper<Creator>> =
        creatorRepository.creators(creatorFilter)
}