package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicRequest
import ci.slyest.the.marvel.verse.domain.usecases.ComicsUseCase
import ci.slyest.the.marvel.verse.presentation.models.Response
import ci.slyest.the.marvel.verse.presentation.models.Status
import ci.slyest.the.marvel.verse.presentation.sources.ComicDataSourceFactory
import io.reactivex.rxjava3.core.Single
import java.util.*

class ComicSearchViewModel(private val useCase: ComicsUseCase): IComicViewModel() {

    var pagedList: LiveData<PagedList<Comic>>? = null
    private lateinit var request: ComicRequest

    fun setRequest(comicRequest: ComicRequest) {
        request = comicRequest
        if (pagedList == null)
            pagedList =
                LivePagedListBuilder(ComicDataSourceFactory(this), pagingConfig).build()
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<ComicDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        request.limit = limit
        request.offset = offset
        useCase(request).let { single ->
            disposable = single.subscribe({
                mutableState.postValue(Response(status = Status.SUCCESSFUL))
                disposable.dispose()
            }, { error ->
                mutableState.postValue(Response(status = Status.ERROR, error = error))
                disposable.dispose()
            })
            return single
        }
    }
}