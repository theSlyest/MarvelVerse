package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.usecases.CharactersUseCase
import ci.slyest.the.marvel.verse.presentation.models.Status
import ci.slyest.the.marvel.verse.presentation.models.Response
import ci.slyest.the.marvel.verse.presentation.sources.CharacterDataSourceFactory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*

class CharacterViewModel(private val useCase: CharactersUseCase): ViewModel() {

    private var mutableState: MutableLiveData<Response> = MutableLiveData()
    val state: LiveData<Response>
        get() {
            return mutableState
        }

    private val characterPagingConfig = PagedList.Config.Builder()
        .setPageSize(20)
        .setPrefetchDistance(40)
        .setEnablePlaceholders(true)
        .build()

    var pagedList: LiveData<PagedList<Character>> =
        LivePagedListBuilder(CharacterDataSourceFactory(this), characterPagingConfig).build()

    private lateinit var disposable: Disposable

    private var mName: String? = null
    private var mNameStartsWith: String? = null
    private var mModifiedSince: Date? = null
    private var mComics: String? = null
    private var mSeries: String? = null
    private var mEvents: String? = null
    private var mStories: String? = null
    private var mOrderBy: String? = null

    fun setQueryParams(
        name: String? = null,
        nameStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: String? = null,
        series: String? = null,
        events: String? = null,
        stories: String? = null,
        orderBy: String? = null
    ) {
        mName = name
        mNameStartsWith = nameStartsWith
        mModifiedSince = modifiedSince
        mComics = comics
        mSeries = series
        mEvents = events
        mStories = stories
        mOrderBy = orderBy
    }

    fun characters(limit: Int? = null, offset: Int? = null) : Single<CharacterDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(mName, mNameStartsWith, mModifiedSince, mComics, mSeries, mEvents, mStories,
            mOrderBy, limit, offset).let { single ->
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