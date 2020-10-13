package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.IntentExtra
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import ci.slyest.the.marvel.verse.presentation.fragments.*
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tabs.*


class TabsActivity : AppCompatActivity() {

    private fun createViewPagerAdapter(): RecyclerView.Adapter<*> {
        return object : FragmentStateAdapter(this) {

            override fun getItemCount(): Int  = resources.getStringArray(R.array.resource_types).size

            override fun createFragment(position: Int): Fragment {
                return when(position) {
                    ResourceType.CHARACTER.ordinal -> CharacterFragment()
                    ResourceType.COMIC.ordinal -> ComicFragment()
                    ResourceType.EVENT.ordinal -> EventFragment()
                    ResourceType.SERIES.ordinal -> SeriesFragment()
//                    ResourceType.STORY.ordinal -> StoryFragment()
//                    ResourceType.CREATOR.ordinal -> CreatorFragment()
                    else -> EmptyRecyclerFragment()
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_tabs, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_search) {
            val intent = Intent(this, SearchActivity::class.java)
            intent.putExtra(IntentExtra.RESULT_TYPE.key, tabs.selectedTabPosition)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}