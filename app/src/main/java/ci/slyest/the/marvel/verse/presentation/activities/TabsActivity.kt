package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import ci.slyest.the.marvel.verse.presentation.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : FragmentActivity() {

    private fun createViewPagerAdapter(): RecyclerView.Adapter<*> {
        return object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int  = resources.getStringArray(R.array.resource_types).size

            override fun createFragment(position: Int): Fragment {
                return ListFragment.create(position)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        pager.adapter = createViewPagerAdapter()
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = resources.getStringArray(R.array.resource_types)[position]
        }.attach()
    }
}