package ci.slyest.the.marvel.verse.presentation.viewmodels

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import io.reactivex.rxjava3.core.Single

abstract class IComicViewModel: IMarvelViewModel() {

    companion object {
        const val PAGE_SIZE = IMarvelViewModel.PAGE_SIZE
        const val PREFETCH_DISTANCE = IMarvelViewModel.PREFETCH_DISTANCE
    }

    abstract override fun fetch(limit: Int?, offset: Int?): Single<ComicDataWrapper>
}