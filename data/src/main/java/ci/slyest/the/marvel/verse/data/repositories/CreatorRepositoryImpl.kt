package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CreatorSource
import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.domain.entities.CreatorFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.CreatorRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of [CreatorRepository]
 * @property creatorSource [CreatorSource] object
 */
class CreatorRepositoryImpl(private val creatorSource: CreatorSource) : CreatorRepository {
    /**
     * Perform a request to get a list of characters by calling [CreatorSource.creators].
     * @param creatorFilter Object carrying the request parameters
     * @return a [Single]<[DataWrapper]<[Creator]>> result object
     */
    override fun creators(creatorFilter: CreatorFilter): Single<DataWrapper<Creator>>
            = creatorSource.creators(creatorFilter)
}