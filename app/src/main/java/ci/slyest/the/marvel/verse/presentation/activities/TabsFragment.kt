package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.adapters.CharacterAdapter
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_tabs.*
import org.koin.android.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_TYPE = "type"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.create] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    private val mViewModel by viewModel<CharacterViewModel>()

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

        if (resourceTypeIndex == 0) {
            val adapter = CharacterAdapter()
//            mViewModel.setQueryParams()
            mViewModel.pagedList.observe(viewLifecycleOwner, { pagedList ->
                adapter.submitList(pagedList)
            })
            recycler.adapter = adapter
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
            ListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TYPE, resourceTypeIndex)
                }
            }
    }
}