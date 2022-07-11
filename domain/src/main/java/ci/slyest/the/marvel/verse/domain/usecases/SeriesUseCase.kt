package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.SeriesFilter
import ci.slyest.the.marvel.verse.domain.repositories.SeriesRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Series list use case: depends on [SeriesRepository] implementation to perform a request.
 */
class SeriesUseCase : KoinComponent {

    /** Injected [SeriesRepository] */
    private val seriesRepository: SeriesRepository by inject()

    /**
     * Perform a request by calling the [SeriesRepository.series] method.
     * @param seriesFilter object carrying the request parameters.
     * @return a [Single]<[SeriesDataWrapper]> result object
     */
    operator fun invoke(seriesFilter: SeriesFilter): Single<SeriesDataWrapper> =
        seriesRepository.series(seriesFilter)
}