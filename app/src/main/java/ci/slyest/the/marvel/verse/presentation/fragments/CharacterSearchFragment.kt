package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.CharacterActivity
import ci.slyest.the.marvel.verse.presentation.adapters.CharacterAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterSearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<CharacterSearchViewModel>()
    private lateinit var adapter: CharacterAdapter

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            create(CharacterSearchFragment(), resourceType, resourceId, startsWith)
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

        adapter = CharacterAdapter(glide)
        refresh(startsWith)
        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putCharacter(mViewModel.data.value?.get(position)!!)
            startActivity(Intent(context, CharacterActivity::class.java))
        }
    }

    override fun refresh(startsWith: String?) {
        mViewModel.request.nameStartsWith = startsWith
        mViewModel.applyRequest()
        mViewModel.data.observe(viewLifecycleOwner) { pagedList ->
            adapter.submitList(pagedList)
        }
    }
}