package ci.slyest.the.marvel.verse.presentation.fragments

import android.view.View
import android.widget.ProgressBar
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.activities.ComicActivity
import ci.slyest.the.marvel.verse.presentation.adapters.ComicAdapter
import ci.slyest.the.marvel.verse.presentation.models.Status
import ci.slyest.the.marvel.verse.presentation.repositories.comicPagedList
import ci.slyest.the.marvel.verse.presentation.utils.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.ComicViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class ComicFragment : IRecyclerFragment() {

    private val mViewModel by viewModel<ComicViewModel>()

    override fun initRecycler() {
        val adapter = ComicAdapter(glide)
        mViewModel.setQueryParams()
        comicPagedList?.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            context?.let { ComicActivity.start(it, position) }
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