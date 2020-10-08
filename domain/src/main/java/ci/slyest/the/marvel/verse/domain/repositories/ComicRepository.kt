package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicRequest
import io.reactivex.rxjava3.core.Single
import java.util.*

interface ComicRepository {

    fun comics(comicRequest: ComicRequest): Single<ComicDataWrapper>
}