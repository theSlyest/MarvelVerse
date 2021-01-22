package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CreatorRequest
import io.reactivex.rxjava3.core.Single

/** Creator repository interface to be implemented in the data component. */
interface CreatorRepository {
    /**
     * Perform a request to get a list of characters
     * @param creatorRequest Object carrying the request parameters
     * @return a [Single]<[CreatorDataWrapper]> result object
     */
    fun creators(creatorRequest: CreatorRequest): Single<CreatorDataWrapper>
}