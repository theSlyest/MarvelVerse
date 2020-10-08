package ci.slyest.the.marvel.verse.presentation.activities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.IntentExtra
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.fragments.CharacterSearchFragment
import ci.slyest.the.marvel.verse.presentation.fragments.EmptySearchFragment
import ci.slyest.the.marvel.verse.presentation.fragments.ISearchFragment
import kotlinx.android.synthetic.main.activity_tabs.*
import kotlinx.android.synthetic.main.app_bar_nav.toolbar

class SearchActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var fragment: ISearchFragment

    private fun loadFragment(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) {
        fragment = when(resourceType) {
            ResourceType.CHARACTER.position ->
                CharacterSearchFragment.create(resourceType, resourceId, startsWith)
//            1 -> ComicSearchFragment()
            else -> EmptySearchFragment()
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        handleIntent(true, intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(false, intent)
    }

    private fun handleIntent(first: Boolean, intent: Intent?) {
        tabs.getTabAt(ResourceHolder.currentType.position)?.select()
        intent?.let {
            var startsWith: String? = null

            if (first) {
                val resourceType = it.getIntExtra(IntentExtra.RESOURCE_TYPE.key, 0)
                val resourceId = it.getIntExtra(IntentExtra.RESOURCE_ID.key, -1)
                loadFragment()
            } else {
                if (Intent.ACTION_SEARCH == it.action) {
                    startsWith = it.getStringExtra(SearchManager.QUERY)
                    //use the query to search your data somehow
                }
                fragment.refresh(startsWith)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_search, menu)

        // Get the SearchView and set the searchable configuration
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.action_search)?.actionView as SearchView).apply {
            // Assumes current activity is the searchable activity
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

//    private fun hideTabs() {
//        tabs.visibility = View.GONE
//    }
//
//    fun showTabs() {
//        tabs.visibility = View.VISIBLE
//    }
//
//    fun hideKeyboard() {
//        val imm = baseContext.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
//    }
}