package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CreatorFilter
import ci.slyest.the.marvel.verse.domain.usecases.CreatorsUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.CreatorDataSource
import io.reactivex.rxjava3.core.Single

class CreatorViewModel(private val useCase: CreatorsUseCase): ICreatorViewModel() {

    companion object {
        @JvmStatic
        var pagedList: LiveData<PagedList<Creator>>? = null
        @JvmStatic
        private var dataSource: CreatorDataSource? = null
    }

    init {
        if (pagedList == null)
            CreatorDataSource.Factory(this).let { factory ->
                pagedList = LivePagedListBuilder(factory, pagingConfig).build()
                dataSource = factory.source
            }
        else
            dataSource?.viewModel = this
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<CreatorDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(CreatorFilter(limit = limit, offset = offset)).let { single ->
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