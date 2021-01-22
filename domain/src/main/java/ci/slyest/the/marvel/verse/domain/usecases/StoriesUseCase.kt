package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryRequest
import ci.slyest.the.marvel.verse.domain.repositories.StoryRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Stories list use case: depends on [StoryRepository] implementation to perform a request.
 */
class StoriesUseCase : KoinComponent {

    /** Injected [StoryRepository] */
    private val storyRepository: StoryRepository by inject()

    /**
     * Perform a request by calling the [StoryRepository.stories] method.
     * @param storyRequest object carrying the request parameters.
     * @return a [Single]<[StoryDataWrapper]> result object
     */
    operator fun invoke(storyRequest: StoryRequest): Single<StoryDataWrapper> =
        storyRepository.stories(storyRequest)
}