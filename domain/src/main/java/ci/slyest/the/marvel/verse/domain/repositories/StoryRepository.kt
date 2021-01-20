package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryRequest
import io.reactivex.rxjava3.core.Single

interface StoryRepository {

    fun stories(storyRequest: StoryRequest): Single<StoryDataWrapper>
}