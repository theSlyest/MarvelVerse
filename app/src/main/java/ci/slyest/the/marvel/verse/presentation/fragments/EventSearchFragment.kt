package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.EventActivity
import ci.slyest.the.marvel.verse.presentation.adapters.EventAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.EventSearchViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class EventSearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<EventSearchViewModel>()
    private lateinit var adapter: EventAdapter

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            ISearchFragment.create(EventSearchFragment(), resourceType, resourceId, startsWith)
    }

    override fun initRecycler() {

        observeState(mViewModel.state)
        
        if (sourceId != -1 && sourceType != -1) {
            when(sourceType) {
                ResourceType.CHARACTER.ordinal ->
                    mViewModel.request.characterId = sourceId
                ResourceType.COMIC.ordinal ->
                    mViewModel.request.comicId = sourceId
                ResourceType.SERIES.ordinal ->
                    mViewModel.request.seriesId = sourceId
                ResourceType.STORY.ordinal ->
                    mViewModel.request.storyId = sourceId
                ResourceType.CREATOR.ordinal ->
                    mViewModel.request.creatorId = sourceId
            }
        }

        adapter = EventAdapter(glide)
        refresh(startsWith)
        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putEvent(mViewModel.data.value?.get(position)!!)
            startActivity(Intent(context, EventActivity::class.java))
        }
    }

    override fun refresh(startsWith: String?) {
        mViewModel.request.nameStartsWith = startsWith
        mViewModel.applyRequest()
        mViewModel.data.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })
    }
}