package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesRequest
import io.reactivex.rxjava3.core.Single

/** Series repository interface to be implemented in the data component. */
interface SeriesRepository {
    /**
     * Perform a request to get a list of characters
     * @param seriesRequest Object carrying the request parameters
     * @return a [Single]<[SeriesDataWrapper]> result object
     */
    fun series(seriesRequest: SeriesRequest): Single<SeriesDataWrapper>
}