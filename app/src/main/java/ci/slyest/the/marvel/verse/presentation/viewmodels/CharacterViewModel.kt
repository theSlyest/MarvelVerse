package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.*
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.CharacterFilter
import ci.slyest.the.marvel.verse.domain.entities.DataWrapper
import ci.slyest.the.marvel.verse.domain.usecases.CharactersUseCase
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.sources.CharacterDataSource
import io.reactivex.rxjava3.core.Single

class CharacterViewModel(private val useCase: CharactersUseCase): ICharacterViewModel() {

    companion object {
        @JvmStatic
        var pagedList: LiveData<PagedList<Character>>? = null
        @JvmStatic
        private var dataSource: CharacterDataSource? = null
    }

    init {
        if (pagedList == null)
            CharacterDataSource.Factory(this).let { factory ->
                pagedList = LivePagedListBuilder(factory, pagingConfig).build()
                dataSource = factory.source
            }
        else
            dataSource?.viewModel = this
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<DataWrapper<Character>> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(CharacterFilter(limit = limit, offset = offset)).let { single ->
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