package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.CharacterActivity
import ci.slyest.the.marvel.verse.presentation.adapters.CharacterAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterFragment : IRecyclerFragment() {
    private val mViewModel by viewModel<CharacterViewModel>()

    override fun initRecycler() {
        observeState(mViewModel.state)

        val adapter = CharacterAdapter(glide)
        CharacterViewModel.pagedList?.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putCharacter(CharacterViewModel.pagedList?.value?.get(position)!!)
            startActivity(Intent(context, CharacterActivity::class.java))
        }
    }
}