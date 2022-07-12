package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.domain.filters.StoryFilter
import ci.slyest.the.marvel.verse.domain.repositories.StoryRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Stories list use case: depends on [StoryRepository] implementation to perform a request.
 */
class StoriesUseCase : KoinComponent {

    /** Injected [StoryRepository] */
    private val storyRepository: StoryRepository by inject()

    /**
     * Perform a request by calling the [StoryRepository.stories] method.
     * @param storyFilter object carrying the request parameters.
     * @return a [Single]<[DataWrapper<Story>]> result object
     */
    operator fun invoke(storyFilter: StoryFilter): Single<DataWrapper<Story>> =
        storyRepository.stories(storyFilter)
}