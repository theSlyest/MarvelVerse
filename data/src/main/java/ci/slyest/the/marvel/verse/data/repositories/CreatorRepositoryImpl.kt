package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.CreatorSource
import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CreatorRequest
import ci.slyest.the.marvel.verse.domain.repositories.CreatorRepository
import io.reactivex.rxjava3.core.Single

class CreatorRepositoryImpl(private val creatorSource: CreatorSource) : CreatorRepository {

    override fun creators(creatorRequest: CreatorRequest): Single<CreatorDataWrapper>
            = creatorSource.creators(creatorRequest)
}