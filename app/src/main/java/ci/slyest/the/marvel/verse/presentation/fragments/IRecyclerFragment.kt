package ci.slyest.the.marvel.verse.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.Response
import ci.slyest.the.marvel.verse.presentation.common.Status
import ci.slyest.the.marvel.verse.presentation.databinding.FragmentRecyclerBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

abstract class IRecyclerFragment: Fragment() {
    private var _binding: FragmentRecyclerBinding? = null
    protected val binding get() = _binding!!
    protected lateinit var glide: RequestManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        glide = Glide.with(this)
        initRecycler()
    }

    protected abstract fun initRecycler()

    protected fun observeState(state: LiveData<Response>) {
        state.observe(viewLifecycleOwner, { response ->
            activity?.findViewById<ProgressBar>(R.id.progress_bar)?.let { progressBar ->
                when (response.status) {
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        requireActivity().window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }
                    else -> {
                        progressBar.visibility = View.INVISIBLE
                        requireActivity().window
                            .clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }
                }
            }
        })
    }
}