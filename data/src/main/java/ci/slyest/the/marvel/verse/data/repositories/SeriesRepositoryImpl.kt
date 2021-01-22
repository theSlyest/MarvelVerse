package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.SeriesSource
import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesRequest
import ci.slyest.the.marvel.verse.domain.repositories.SeriesRepository
import io.reactivex.rxjava3.core.Single

/**
 * Implementation of [SeriesRepository]
 * @property seriesSource [SeriesSource] object
 */
class SeriesRepositoryImpl(private val seriesSource: SeriesSource) : SeriesRepository {
    /**
     * Perform a request to get a list of characters by calling [SeriesSource.series].
     * @param seriesRequest Object carrying the request parameters.
     * @return a [Single]<[SeriesDataWrapper]> result object.
     */
    override fun series(seriesRequest: SeriesRequest): Single<SeriesDataWrapper>
            = seriesSource.series(seriesRequest)
}