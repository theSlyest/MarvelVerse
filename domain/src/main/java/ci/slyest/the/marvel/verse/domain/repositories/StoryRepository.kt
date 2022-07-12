package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.domain.filters.StoryFilter
import io.reactivex.rxjava3.core.Single

/** Story repository interface to be implemented in the data module. */
interface StoryRepository {
    /**
     * Perform a request to get a list of characters
     * @param storyFilter Object carrying the request parameters
     * @return a [Single]<[DataWrapper<Story>]> result object
     */
    fun stories(storyFilter: StoryFilter): Single<DataWrapper<Story>>
}