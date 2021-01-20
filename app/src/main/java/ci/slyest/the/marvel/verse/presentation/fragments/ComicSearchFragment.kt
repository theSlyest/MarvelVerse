package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.ComicActivity
import ci.slyest.the.marvel.verse.presentation.adapters.ComicAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.ComicSearchViewModel
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
        
        if (sourceId != -1 && sourceType != -1) {
            when(sourceType) {
                ResourceType.CHARACTER.ordinal ->
                    mViewModel.request.characterId = sourceId
                ResourceType.EVENT.ordinal ->
                    mViewModel.request.eventId = sourceId
                ResourceType.SERIES.ordinal ->
                    mViewModel.request.seriesId = sourceId
                ResourceType.STORY.ordinal ->
                    mViewModel.request.storyId = sourceId
                ResourceType.CREATOR.ordinal ->
                    mViewModel.request.creatorId = sourceId
            }
        }

        adapter = ComicAdapter(glide)
        refresh(startsWith)
        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
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