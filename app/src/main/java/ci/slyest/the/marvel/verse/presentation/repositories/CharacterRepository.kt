package ci.slyest.the.marvel.verse.presentation.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import ci.slyest.the.marvel.verse.domain.entities.Character

var characterPagedList: LiveData<PagedList<Character>>? = null
