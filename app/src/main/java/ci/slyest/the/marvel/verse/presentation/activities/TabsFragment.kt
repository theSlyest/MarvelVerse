package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.adapters.CharacterAdapter
import ci.slyest.the.marvel.verse.presentation.adapters.ComicAdapter
import ci.slyest.the.marvel.verse.presentation.models.Status
import ci.slyest.the.marvel.verse.presentation.repositories.characterPagedList
import ci.slyest.the.marvel.verse.presentation.repositories.comicPagedList
import ci.slyest.the.marvel.verse.presentation.utils.onItemClick
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import ci.slyest.the.marvel.verse.presentation.viewmodels.ComicViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_tabs.*
import org.koin.android.viewmodel.ext.android.viewModel


private const val ARG_TYPE = "type"

/**
 * A simple [Fragment] subclass.
 * Use the [TabsFragment.create] factory method to
 * create an instance of this fragment.
 */
class TabsFragment : Fragment() {

    private val characterViewModel by viewModel<CharacterViewModel>()
    private val comicViewModel by viewModel<ComicViewModel>()

    private var resourceTypeIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            resourceTypeIndex = it.getInt(ARG_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tabs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val glide = Glide.with(this)

        when (resourceTypeIndex) {
            0 -> { // Characters
                val adapter = CharacterAdapter(glide)
                characterViewModel.setQueryParams()
                characterPagedList?.observe(viewLifecycleOwner, { pagedList ->
                    adapter.submitList(pagedList)
                })

                recycler.adapter = adapter
                recycler.onItemClick { _, position, _ ->
                    context?.let { CharacterActivity.start(it, position) }
                }

                characterViewModel.state.observe(viewLifecycleOwner, { response ->
                    activity?.findViewById<ProgressBar>(R.id.progress_bar)?.let { progressBar ->
                        when (response.status) {
                            Status.LOADING -> progressBar.visibility = View.VISIBLE
                            else -> progressBar.visibility = View.INVISIBLE
                        }
                    }
                })
            }

            1 -> { // Comics
                val adapter = ComicAdapter(glide)
                comicViewModel.setQueryParams()
                comicPagedList?.observe(viewLifecycleOwner, { pagedList ->
                    adapter.submitList(pagedList)
                })

                recycler.adapter = adapter
                recycler.onItemClick { _, position, _ ->
                    context?.let { ComicActivity.start(it, position) }
                }

                comicViewModel.state.observe(viewLifecycleOwner, { response ->
                    activity?.findViewById<ProgressBar>(R.id.progress_bar)?.let { progressBar ->
                        when (response.status) {
                            Status.LOADING -> progressBar.visibility = View.VISIBLE
                            else -> progressBar.visibility = View.INVISIBLE
                        }
                    }
                })
            }
            else -> {}
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param resourceTypeIndex Parameter.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun create(resourceTypeIndex: Int) =
            TabsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TYPE, resourceTypeIndex)
                }
            }
    }
}