package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.fragments.CharacterFragment
import ci.slyest.the.marvel.verse.presentation.fragments.ComicFragment
import ci.slyest.the.marvel.verse.presentation.fragments.EmptyFragment
import ci.slyest.the.marvel.verse.presentation.utils.setAttribution
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity() {

    private fun createViewPagerAdapter(): RecyclerView.Adapter<*> {
        return object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int  = resources.getStringArray(R.array.resource_types).size

            override fun createFragment(position: Int): Fragment {
                return when(position) {
                    0 -> CharacterFragment()
                    1 -> ComicFragment()
                    else -> EmptyFragment()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)

        pager.adapter = createViewPagerAdapter()
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = resources.getStringArray(R.array.resource_types)[position]
        }.attach()
    }
}