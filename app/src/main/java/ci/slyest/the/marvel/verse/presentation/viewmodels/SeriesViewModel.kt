package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Series
import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.SeriesFilter
import ci.slyest.the.marvel.verse.domain.usecases.SeriesUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.SeriesDataSource
import io.reactivex.rxjava3.core.Single

class SeriesViewModel(private val useCase: SeriesUseCase): ISeriesViewModel() {

    companion object {
        @JvmStatic
        var pagedList: LiveData<PagedList<Series>>? = null
        @JvmStatic
        private var dataSource: SeriesDataSource? = null
    }

    init {
        if (pagedList == null)
            SeriesDataSource.Factory(this).let { factory ->
                pagedList = LivePagedListBuilder(factory, pagingConfig).build()
                dataSource = factory.source
            }
        else
            dataSource?.viewModel = this
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<SeriesDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(SeriesFilter(limit = limit, offset = offset)).let { single ->
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