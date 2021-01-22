package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.StorySource
import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryRequest
import ci.slyest.the.marvel.verse.domain.repositories.StoryRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of [StoryRepository]
 * @property storySource [StorySource] object
 */
class StoryRepositoryImpl(private val storySource: StorySource) : StoryRepository {
    /**
     * Perform a request to get a list of characters by calling [StorySource.stories].
     * @param storyRequest Object carrying the request parameters.
     * @return a [Single]<[StoryDataWrapper]> result object.
     */
    override fun stories(storyRequest: StoryRequest): Single<StoryDataWrapper>
            = storySource.stories(storyRequest)
}