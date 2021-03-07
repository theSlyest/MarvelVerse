package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.domain.entities.ComicFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.usecases.ComicsUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.ComicDataSource
import io.reactivex.rxjava3.core.Single

class ComicSearchViewModel(private val useCase: ComicsUseCase): IComicViewModel(), ISearchViewModel<Comic> {

    var request = ComicFilter()
    private lateinit var pagedList: LiveData<PagedList<Comic>>
    override val data
        get() = pagedList

    override fun applyRequest() {
        pagedList =
            LivePagedListBuilder(ComicDataSource.Factory(this), pagingConfig).build()
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<DataWrapper<Comic>> {
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