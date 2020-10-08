package ci.slyest.the.marvel.verse.presentation.fragments

import ci.slyest.the.marvel.verse.presentation.activities.CharacterActivity
import ci.slyest.the.marvel.verse.presentation.adapters.CharacterAdapter
import ci.slyest.the.marvel.verse.presentation.custom.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterSearchViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterSearchFragment : ISearchFragment() {

    private val mViewModel by viewModel<CharacterSearchViewModel>()

    companion object {
        fun create(resourceType: Int? = null, resourceId: Int? = null) =
            ISearchFragment.create(CharacterSearchFragment(), resourceType, resourceId)
    }

    override fun initRecycler() {
        observeState(mViewModel.state)

        val adapter = CharacterAdapter(glide)
        mViewModel.setRequest(nameStartsWith = startsWith)
        mViewModel.pagedList?.observe(viewLifecycleOwner, { pagedList ->
            adapter.submitList(pagedList)
        })

        recycler.adapter = adapter
        recycler.onItemClick { _, position, _ ->
            context?.let { CharacterActivity.start(it, position, true) }
        }
    }

    override fun refresh(startsWith: String?) {
        mViewModel.setRequest(nameStartsWith = startsWith)
    }
}