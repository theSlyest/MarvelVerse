package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.CharacterActivity
import ci.slyest.the.marvel.verse.presentation.adapters.CharacterAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterSearchViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterSearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<CharacterSearchViewModel>()
    private lateinit var adapter: CharacterAdapter

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            ISearchFragment.create(CharacterSearchFragment(), resourceType, resourceId, startsWith)
    }

    override fun initRecycler() {
        observeState(mViewModel.state)

        if (resourceId != -1 && resourceType != -1) {
            when(resourceType) {
                ResourceType.COMIC.ordinal ->
                    mViewModel.request.comicId = resourceId
                ResourceType.EVENT.ordinal ->
                    mViewModel.request.eventId = resourceId
                ResourceType.SERIES.ordinal ->
                    mViewModel.request.seriesId = resourceId
                ResourceType.STORY.ordinal ->
                    mViewModel.request.storyId = resourceId
            }
        }

        adapter = CharacterAdapter(glide)
        refresh(startsWith)
        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            ResourceHolder.putCharacter(mViewModel.data.value?.get(position)!!)
            startActivity(Intent(context, CharacterActivity::class.java))
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