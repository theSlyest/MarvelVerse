package ci.slyest.the.marvel.verse.data.repositories

import ci.slyest.the.marvel.verse.data.remote.ComicSource
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicRequest
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import io.reactivex.rxjava3.core.Single

class ComicRepositoryImpl(private val comicSource: ComicSource): ComicRepository {

    override fun comics(comicRequest: ComicRequest): Single<ComicDataWrapper>
            = comicSource.comics(comicRequest)
}