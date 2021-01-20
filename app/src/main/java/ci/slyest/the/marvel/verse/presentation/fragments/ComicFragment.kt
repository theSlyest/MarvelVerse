package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.ComicActivity
import ci.slyest.the.marvel.verse.presentation.adapters.ComicAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.ComicViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ComicFragment : IRecyclerFragment() {

    private val mViewModel by viewModel<ComicViewModel>()

    override fun initRecycler() {
        observeState(mViewModel.state)

        val adapter = ComicAdapter(glide)
        ComicViewModel.pagedList!!.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putComic(ComicViewModel.pagedList?.value?.get(position)!!)
            startActivity(Intent(context, ComicActivity::class.java))
        }
    }
}