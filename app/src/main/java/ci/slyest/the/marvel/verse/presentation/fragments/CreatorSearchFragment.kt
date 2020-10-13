package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.CreatorActivity
import ci.slyest.the.marvel.verse.presentation.adapters.CreatorAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CreatorSearchViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class CreatorSearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<CreatorSearchViewModel>()
    private lateinit var adapter: CreatorAdapter

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            ISearchFragment.create(CreatorSearchFragment(), resourceType, resourceId, startsWith)
    }

    override fun initRecycler() {
        observeState(mViewModel.state)

        if (sourceId != -1 && sourceType != -1) {
            when(sourceType) {
                ResourceType.COMIC.ordinal ->
                    mViewModel.request.comicId = sourceId
                ResourceType.EVENT.ordinal ->
                    mViewModel.request.eventId = sourceId
                ResourceType.SERIES.ordinal ->
                    mViewModel.request.seriesId = sourceId
                ResourceType.STORY.ordinal ->
                    mViewModel.request.storyId = sourceId
            }
        }

        adapter = CreatorAdapter(glide)
        refresh(startsWith)
        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            ResourceHolder.putCreator(mViewModel.data.value?.get(position)!!)
            startActivity(Intent(context, CreatorActivity::class.java))
        }
    }

    override fun refresh(startsWith: String?) {
        mViewModel.request.lastNameStartsWith = startsWith
        mViewModel.applyRequest()
        mViewModel.data.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })
    }
}