package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.ComicSource
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.ComicFilter
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of [ComicRepository]
 * @property comicSource [ComicSource] object
 */
class ComicRepositoryImpl(private val comicSource: ComicSource): ComicRepository {
    /**
     * Perform a request to get a list of characters by calling [ComicSource.comics].
     * @param comicFilter Object carrying the request parameters
     * @return a [Single]<[ComicDataWrapper]> result object
     */
    override fun comics(comicFilter: ComicFilter): Single<ComicDataWrapper>
            = comicSource.comics(comicFilter)
}