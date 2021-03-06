package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicFilter
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Comics list use case: depends on [ComicRepository] implementation to perform a request.
 */
class ComicsUseCase : KoinComponent {

    /** Injected [ComicRepository] */
    private val comicRepository: ComicRepository by inject()

    /**
     * Perform a request by calling the [ComicRepository.comics] method.
     * @param comicFilter object carrying the request parameters.
     * @return a [Single]<[ComicDataWrapper]> result object
     */
    operator fun invoke(comicFilter: ComicFilter): Single<ComicDataWrapper> =
        comicRepository.comics(comicFilter)
}