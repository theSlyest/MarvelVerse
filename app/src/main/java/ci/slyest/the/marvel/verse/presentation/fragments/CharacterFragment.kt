package ci.slyest.the.marvel.verse.presentation.fragments

import android.view.View
import android.widget.ProgressBar
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.activities.CharacterActivity
import ci.slyest.the.marvel.verse.presentation.adapters.CharacterAdapter
import ci.slyest.the.marvel.verse.presentation.models.Status
import ci.slyest.the.marvel.verse.presentation.repositories.characterPagedList
import ci.slyest.the.marvel.verse.presentation.utils.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterFragment : IRecyclerFragment() {

    private val mViewModel by viewModel<CharacterViewModel>()

    override fun initRecycler() {
        val adapter = CharacterAdapter(glide)
        mViewModel.setQueryParams()
        characterPagedList?.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            context?.let { CharacterActivity.start(it, position) }
        }

        mViewModel.state.observe(viewLifecycleOwner, { response ->
            activity?.findViewById<ProgressBar>(R.id.progress_bar)?.let { progressBar ->
                when (response.status) {
                    Status.LOADING -> progressBar.visibility = View.VISIBLE
                    else -> progressBar.visibility = View.INVISIBLE
                }
            }
        })
    }
}