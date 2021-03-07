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

class ComicViewModel(private val useCase: ComicsUseCase): IComicViewModel() {

    companion object {
        @JvmStatic
        var pagedList: LiveData<PagedList<Comic>>? = null
        @JvmStatic
        private var dataSource: ComicDataSource? = null
    }

    init {
        if (pagedList == null)
            ComicDataSource.Factory(this).let { factory ->
                dataSource = factory.source
                pagedList =
                    LivePagedListBuilder(factory, pagingConfig).build()
            }
        else
            dataSource?.viewModel = this
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<DataWrapper<Comic>> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(ComicFilter(limit = limit, offset = offset)).let { single ->
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