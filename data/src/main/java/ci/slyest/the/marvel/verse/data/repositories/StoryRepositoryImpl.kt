package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.StorySource
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.domain.filters.StoryFilter
import ci.slyest.the.marvel.verse.domain.repositories.StoryRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of [StoryRepository]
 * @property storySource [StorySource] object
 */
class StoryRepositoryImpl(private val storySource: StorySource) : StoryRepository {
    /**
     * Perform a request to get a list of characters by calling [StorySource.stories].
     * @param storyFilter Object carrying the request parameters.
     * @return a [Single]<[DataWrapper<Story>]> result object.
     */
    override fun stories(storyFilter: StoryFilter): Single<DataWrapper<Story>>
            = storySource.stories(storyFilter)
}