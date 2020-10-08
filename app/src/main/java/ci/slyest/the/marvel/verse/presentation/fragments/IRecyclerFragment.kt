package ci.slyest.the.marvel.verse.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.models.Response
import ci.slyest.the.marvel.verse.presentation.models.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

abstract class IRecyclerFragment: Fragment() {

    protected lateinit var glide: RequestManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false)
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
                    Status.LOADING -> progressBar.visibility = View.VISIBLE
                    else -> progressBar.visibility = View.INVISIBLE
                }
            }
        })
    }
}