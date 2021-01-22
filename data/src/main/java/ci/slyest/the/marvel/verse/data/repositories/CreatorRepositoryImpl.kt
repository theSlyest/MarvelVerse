package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CreatorSource
import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CreatorRequest
import ci.slyest.the.marvel.verse.domain.repositories.CreatorRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of [CreatorRepository]
 * @property creatorSource [CreatorSource] object
 */
class CreatorRepositoryImpl(private val creatorSource: CreatorSource) : CreatorRepository {
    /**
     * Perform a request to get a list of characters by calling [CreatorSource.creators].
     * @param creatorRequest Object carrying the request parameters
     * @return a [Single]<[CreatorDataWrapper]> result object
     */
    override fun creators(creatorRequest: CreatorRequest): Single<CreatorDataWrapper>
            = creatorSource.creators(creatorRequest)
}