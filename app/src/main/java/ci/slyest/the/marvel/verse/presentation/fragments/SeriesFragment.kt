package ci.slyest.the.marvel.verse.presentation.fragments

import android.content.Intent
import ci.slyest.the.marvel.verse.presentation.activities.SeriesActivity
import ci.slyest.the.marvel.verse.presentation.adapters.SeriesAdapter
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.SeriesViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class SeriesFragment : IRecyclerFragment() {

    private val mViewModel by viewModel<SeriesViewModel>()

    override fun initRecycler() {
        observeState(mViewModel.state)

        val adapter = SeriesAdapter(glide)
        SeriesViewModel.pagedList!!.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            ResourceHolder.putSeries(SeriesViewModel.pagedList?.value?.get(position)!!)
            startActivity(Intent(context, SeriesActivity::class.java))
        }
    }
}