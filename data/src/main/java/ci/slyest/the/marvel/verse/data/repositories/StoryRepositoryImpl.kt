package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.StorySource
import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryRequest
import ci.slyest.the.marvel.verse.domain.repositories.StoryRepository
import io.reactivex.rxjava3.core.Single

class StoryRepositoryImpl(private val storySource: StorySource) : StoryRepository {

    override fun stories(storyRequest: StoryRequest): Single<StoryDataWrapper>
            = storySource.stories(storyRequest)
}