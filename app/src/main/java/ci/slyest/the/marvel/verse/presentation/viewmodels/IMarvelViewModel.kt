package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.presentation.models.Response
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable

abstract class IMarvelViewModel: ViewModel() {

    companion object {

        const val PAGE_SIZE = 33
        const val PREFETCH_DISTANCE = 33

        val pagingConfig = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setPrefetchDistance(PREFETCH_DISTANCE)
            .setEnablePlaceholders(false)
            .build()
    }

    protected var mutableState: MutableLiveData<Response> = MutableLiveData()
    val state: LiveData<Response>
        get() = mutableState

    protected lateinit var disposable: Disposable

    abstract fun fetch(limit: Int? = null, offset: Int? = null): Single<*>
}