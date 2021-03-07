package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.presentation.common.Response
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable

/** Super class for list activities ViewModels */
abstract class IMarvelViewModel: ViewModel() {

    /** PagedList configuration */
    companion object {

        /** Number of objects per page. */
        const val PAGE_SIZE = 32
        /** Number of prefetched objects. */
        const val PREFETCH_DISTANCE = 16

        /** Configuration object for [PagedList]. */
        val pagingConfig = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setPrefetchDistance(PREFETCH_DISTANCE)
            .setEnablePlaceholders(false)
            .build()
    }

    /** LiveData that receives the request result. */
    protected var mutableState: MutableLiveData<Response> = MutableLiveData()

    /** Read-only [LiveData] for the request result. */
    val state: LiveData<Response>
        get() = mutableState

    /** Used to suscribe to the [Single] result object. */
    protected lateinit var disposable: Disposable

    /** Perform the request and return the result wrapped in a [Single] object. */
    abstract fun fetch(limit: Int? = null, offset: Int? = null): Single<*>
}