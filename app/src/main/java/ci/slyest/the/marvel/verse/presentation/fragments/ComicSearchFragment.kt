package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.ComicActivity
import ci.slyest.the.marvel.verse.presentation.adapters.ComicAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.ComicSearchViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class ComicSearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<ComicSearchViewModel>()
    private lateinit var adapter: ComicAdapter

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            ISearchFragment.create(ComicSearchFragment(), resourceType, resourceId, startsWith)
    }

    override fun initRecycler() {

        observeState(mViewModel.state)
        
        if (resourceId != -1 && resourceType != -1) {
            when(resourceType) {
                ResourceType.CHARACTER.ordinal ->
                    mViewModel.request.characterId = resourceId
                ResourceType.EVENT.ordinal ->
                    mViewModel.request.eventId = resourceId
                ResourceType.SERIES.ordinal ->
                    mViewModel.request.seriesId = resourceId
                ResourceType.STORY.ordinal ->
                    mViewModel.request.storyId = resourceId
                ResourceType.CREATOR.ordinal ->
                    mViewModel.request.creatorId = resourceId
            }
        }

        adapter = ComicAdapter(glide)
        refresh(startsWith)
        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            ResourceHolder.putComic(mViewModel.data.value?.get(position)!!)
            startActivity(Intent(context, ComicActivity::class.java))
        }
    }

    override fun refresh(startsWith: String?) {
        mViewModel.request.titleStartsWith = startsWith
        mViewModel.applyRequest()
        mViewModel.data.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })
    }
}