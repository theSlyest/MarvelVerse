package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import ci.slyest.the.marvel.verse.domain.usecases.CharactersUseCase
import ci.slyest.the.marvel.verse.presentation.models.Response
import ci.slyest.the.marvel.verse.presentation.models.Status
import ci.slyest.the.marvel.verse.presentation.sources.CharacterDataSourceFactory
import io.reactivex.rxjava3.core.Single

class CharacterSearchViewModel(private val useCase: CharactersUseCase): ICharacterViewModel(), ISearchViewModel<Character> {

    var request = CharacterRequest()
    private lateinit var pagedList: LiveData<PagedList<Character>>
    override val data: LiveData<PagedList<Character>>
        get() = pagedList

    override fun applyRequest() {
        pagedList =
            LivePagedListBuilder(CharacterDataSourceFactory(this), pagingConfig).build()
    }

    override fun fetch(limit: Int?, offset: Int?) : Single<CharacterDataWrapper> {
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