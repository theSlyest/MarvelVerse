package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicRequest
import io.reactivex.rxjava3.core.Single

/** Comic repository interface to be implemented in the data module. */
interface ComicRepository {
    /**
     * Perform a request to get a list of characters
     * @param comicRequest Object carrying the request parameters
     * @return a [Single]<[ComicDataWrapper]> result object
     */
    fun comics(comicRequest: ComicRequest): Single<ComicDataWrapper>
}