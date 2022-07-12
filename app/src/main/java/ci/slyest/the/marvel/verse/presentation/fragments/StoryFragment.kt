package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.StoryActivity
import ci.slyest.the.marvel.verse.presentation.adapters.StoryAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.StoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoryFragment : IRecyclerFragment() {

    private val mViewModel by viewModel<StoryViewModel>()

    override fun initRecycler() {
        observeState(mViewModel.state)

        val adapter = StoryAdapter(glide)
        StoryViewModel.pagedList!!.observe(viewLifecycleOwner) { pagedList ->
            adapter.submitList(pagedList)
        }

        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putStory(StoryViewModel.pagedList?.value?.get(position)!!)
            startActivity(Intent(context, StoryActivity::class.java))
        }
    }
}