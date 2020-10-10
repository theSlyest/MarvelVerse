package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CreatorRequest
import io.reactivex.rxjava3.core.Single

interface CreatorRepository {

    fun creators(creatorRequest: CreatorRequest): Single<CreatorDataWrapper>
}