package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.SeriesSource
import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesRequest
import ci.slyest.the.marvel.verse.domain.repositories.SeriesRepository
import io.reactivex.rxjava3.core.Single

class SeriesRepositoryImpl(private val seriesSource: SeriesSource) : SeriesRepository {

    override fun series(seriesRequest: SeriesRequest): Single<SeriesDataWrapper>
            = seriesSource.series(seriesRequest)
}