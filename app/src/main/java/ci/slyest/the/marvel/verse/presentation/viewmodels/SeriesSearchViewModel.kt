package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Series
import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.SeriesFilter
import ci.slyest.the.marvel.verse.domain.usecases.SeriesUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.SeriesDataSource
import io.reactivex.rxjava3.core.Single

class SeriesSearchViewModel(private val useCase: SeriesUseCase): ISeriesViewModel(), ISearchViewModel<Series> {

    var request = SeriesFilter()
    private lateinit var pagedList: LiveData<PagedList<Series>>
    override val data
        get() = pagedList

    override fun applyRequest() {
        pagedList =
            LivePagedListBuilder(SeriesDataSource.Factory(this), pagingConfig).build()
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<SeriesDataWrapper> {
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