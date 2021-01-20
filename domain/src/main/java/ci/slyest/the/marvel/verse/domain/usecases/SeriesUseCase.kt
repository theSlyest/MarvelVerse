package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesRequest
import ci.slyest.the.marvel.verse.domain.repositories.SeriesRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class SeriesUseCase : KoinComponent {

    private val seriesRepository: SeriesRepository by inject()

    operator fun invoke(seriesRequest: SeriesRequest): Single<SeriesDataWrapper> =
        seriesRepository.series(seriesRequest)
}