package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Series
import ci.slyest.the.marvel.verse.domain.filters.SeriesFilter
import io.reactivex.rxjava3.core.Single

/** Series repository interface to be implemented in the data module. */
interface SeriesRepository {
    /**
     * Perform a request to get a list of characters
     * @param seriesFilter Object carrying the request parameters
     * @return a [Single]<[DataWrapper<Series>]> result object
     */
    fun series(seriesFilter: SeriesFilter): Single<DataWrapper<Series>>
}