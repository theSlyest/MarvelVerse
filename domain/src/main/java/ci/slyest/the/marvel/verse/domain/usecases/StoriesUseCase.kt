package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.StoryRequest
import ci.slyest.the.marvel.verse.domain.repositories.StoryRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class StoriesUseCase : KoinComponent {

    private val storyRepository: StoryRepository by inject()

    operator fun invoke(storyRequest: StoryRequest): Single<StoryDataWrapper> =
        storyRepository.stories(storyRequest)
}