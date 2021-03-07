package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.domain.filters.CreatorFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import io.reactivex.rxjava3.core.Single

/** Creator repository interface to be implemented in the data module. */
interface CreatorRepository {
    /**
     * Perform a request to get a list of characters
     * @param creatorFilter Object carrying the request parameters
     * @return a [Single]<[DataWrapper]<[Creator]>> result object
     */
    fun creators(creatorFilter: CreatorFilter): Single<DataWrapper<Creator>>
}