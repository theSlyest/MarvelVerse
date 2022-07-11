package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.CreatorActivity
import ci.slyest.the.marvel.verse.presentation.adapters.CreatorAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CreatorViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreatorFragment : IRecyclerFragment() {

    private val mViewModel by viewModel<CreatorViewModel>()

    override fun initRecycler() {
        observeState(mViewModel.state)

        val adapter = CreatorAdapter(glide)
        CreatorViewModel.pagedList?.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putCreator(CreatorViewModel.pagedList?.value?.get(position)!!)
            startActivity(Intent(context, CreatorActivity::class.java))
        }
    }
}