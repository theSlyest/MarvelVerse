package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.StoryActivity
import ci.slyest.the.marvel.verse.presentation.adapters.StoryAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.StorySearchViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class StorySearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<StorySearchViewModel>()
    private lateinit var adapter: StoryAdapter

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            ISearchFragment.create(StorySearchFragment(), resourceType, resourceId, startsWith)
    }

    override fun initRecycler() {
        observeState(mViewModel.state)
        
        if (sourceId != -1 && sourceType != -1) {
            when(sourceType) {
                ResourceType.CHARACTER.ordinal ->
                    mViewModel.request.characterId = sourceId
                ResourceType.EVENT.ordinal ->
                    mViewModel.request.eventId = sourceId
                ResourceType.COMIC.ordinal ->
                    mViewModel.request.comicId = sourceId
                ResourceType.SERIES.ordinal ->
                    mViewModel.request.seriesId = sourceId
                ResourceType.CREATOR.ordinal ->
                    mViewModel.request.creatorId = sourceId
            }
        }

        adapter = StoryAdapter(glide)
        refresh(startsWith)
        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putStory(mViewModel.data.value?.get(position)!!)
            startActivity(Intent(context, StoryActivity::class.java))
        }
    }

    override fun refresh(startsWith: String?) {
//        mViewModel.request.modifiedSince = startsWith
        mViewModel.applyRequest()
        mViewModel.data.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })
    }
}