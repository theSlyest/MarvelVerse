package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicRequest
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class ComicsUseCase : KoinComponent {

    private val comicRepository: ComicRepository by inject()

    operator fun invoke(comicRequest: ComicRequest): Single<ComicDataWrapper> =
        comicRepository.comics(comicRequest)
}