package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.SeriesActivity
import ci.slyest.the.marvel.verse.presentation.adapters.SeriesAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.SeriesSearchViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class SeriesSearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<SeriesSearchViewModel>()
    private lateinit var adapter: SeriesAdapter

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            ISearchFragment.create(SeriesSearchFragment(), resourceType, resourceId, startsWith)
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
                ResourceType.STORY.ordinal ->
                    mViewModel.request.storyId = sourceId
                ResourceType.CREATOR.ordinal ->
                    mViewModel.request.creatorId = sourceId
            }
        }

        adapter = SeriesAdapter(glide)
        refresh(startsWith)
        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            ResourceHolder.putSeries(mViewModel.data.value?.get(position)!!)
            startActivity(Intent(context, SeriesActivity::class.java))
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