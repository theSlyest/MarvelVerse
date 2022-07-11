package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import ci.slyest.the.marvel.verse.domain.filters.CreatorFilter
import ci.slyest.the.marvel.verse.domain.usecases.CreatorsUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.CreatorDataSource
import io.reactivex.rxjava3.core.Single

class CreatorSearchViewModel(private val useCase: CreatorsUseCase): ICreatorViewModel(), ISearchViewModel<Creator> {

    var request = CreatorFilter()
    private lateinit var pagedList: LiveData<PagedList<Creator>>
    override val data: LiveData<PagedList<Creator>>
        get() = pagedList

    override fun applyRequest() {
        pagedList =
            LivePagedListBuilder(CreatorDataSource.Factory(this), pagingConfig).build()
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<CreatorDataWrapper> {
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