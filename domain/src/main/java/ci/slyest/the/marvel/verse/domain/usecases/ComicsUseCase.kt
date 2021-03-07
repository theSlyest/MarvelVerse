package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.domain.entities.ComicFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
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
     * @return a [Single]<[DataWrapper]<[Comic]>> result object
     */
    operator fun invoke(comicFilter: ComicFilter): Single<DataWrapper<Comic>> =
        comicRepository.comics(comicFilter)
}