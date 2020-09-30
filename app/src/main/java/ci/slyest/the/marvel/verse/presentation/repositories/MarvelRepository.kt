package ci.slyest.the.marvel.verse.presentation.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.domain.entities.Comic

const val PAGE_SIZE = 33
const val PREFETCH_DISTANCE = 33

val pagingConfig = PagedList.Config.Builder()
    .setPageSize(PAGE_SIZE)
    .setPrefetchDistance(PREFETCH_DISTANCE)
    .setEnablePlaceholders(false)
    .build()

var characterPagedList: LiveData<PagedList<Character>>? = null

var comicPagedList: LiveData<PagedList<Comic>>? = null
