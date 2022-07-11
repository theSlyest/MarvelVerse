package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface ISearchViewModel<T : Any> {

    val data: LiveData<PagedList<T>>

    /**
     * Call after every request modification
     */
    fun applyRequest()
}