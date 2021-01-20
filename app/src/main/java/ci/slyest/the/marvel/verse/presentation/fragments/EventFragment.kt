package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.EventActivity
import ci.slyest.the.marvel.verse.presentation.adapters.EventAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.EventViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class EventFragment : IRecyclerFragment() {

    private val mViewModel by viewModel<EventViewModel>()

    override fun initRecycler() {
        observeState(mViewModel.state)

        val adapter = EventAdapter(glide)
        EventViewModel.pagedList!!.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        binding.recycler.adapter = adapter
        binding.recycler.onItemClick { _, position, _ ->
            ResourceHolder.putEvent(EventViewModel.pagedList?.value?.get(position)!!)
            startActivity(Intent(context, EventActivity::class.java))
        }
    }
}