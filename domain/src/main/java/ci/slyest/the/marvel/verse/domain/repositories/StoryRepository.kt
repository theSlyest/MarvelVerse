package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryFilter
import io.reactivex.rxjava3.core.Single

/** Story repository interface to be implemented in the data module. */
interface StoryRepository {
    /**
     * Perform a request to get a list of characters
     * @param storyFilter Object carrying the request parameters
     * @return a [Single]<[StoryDataWrapper]> result object
     */
    fun stories(storyFilter: StoryFilter): Single<StoryDataWrapper>
}