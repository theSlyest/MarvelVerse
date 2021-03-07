package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * Interface for the ViewModels of SearchActivity
 * @param T The type of resource object of the ViewModel.
 */
interface ISearchViewModel<T> {

    /** Paged list of data objects. */
    val data: LiveData<PagedList<T>>

    /** Call after every request modification. */
    fun applyRequest()
}