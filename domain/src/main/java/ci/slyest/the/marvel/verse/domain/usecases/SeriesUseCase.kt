package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.entities.Series
import ci.slyest.the.marvel.verse.domain.entities.SeriesFilter
import ci.slyest.the.marvel.verse.domain.repositories.SeriesRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Series list use case: depends on [SeriesRepository] implementation to perform a request.
 */
class SeriesUseCase : KoinComponent {

    /** Injected [SeriesRepository] */
    private val seriesRepository: SeriesRepository by inject()

    /**
     * Perform a request by calling the [SeriesRepository.series] method.
     * @param seriesFilter object carrying the request parameters.
     * @return a [Single]<[DataWrapper]<[Series]>> result object
     */
    operator fun invoke(seriesFilter: SeriesFilter): Single<DataWrapper<Series>> =
        seriesRepository.series(seriesFilter)
}