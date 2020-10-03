package ci.slyest.the.marvel.verse.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

private const val ARG_TYPE = "type"

abstract class IRecyclerFragment : Fragment() {

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
}