package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesRequest
import io.reactivex.rxjava3.core.Single

interface SeriesRepository {

    fun series(seriesRequest: SeriesRequest): Single<SeriesDataWrapper>
}