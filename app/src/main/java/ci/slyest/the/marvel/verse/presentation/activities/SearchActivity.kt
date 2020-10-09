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
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.fragments.CharacterSearchFragment
import ci.slyest.the.marvel.verse.presentation.fragments.ComicSearchFragment
import ci.slyest.the.marvel.verse.presentation.fragments.EmptySearchFragment
import ci.slyest.the.marvel.verse.presentation.fragments.ISearchFragment
import kotlinx.android.synthetic.main.app_bar_nav.*

class SearchActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var fragment: ISearchFragment
    private var resourceType: Int? = null
    private var resourceId: Int? = null

    private fun loadFragment(resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) {
        fragment = when(resourceType) {
            ResourceType.CHARACTER.ordinal ->
                CharacterSearchFragment.create(resourceType, resourceId, startsWith)
            ResourceType.COMIC.ordinal ->
                ComicSearchFragment.create(resourceType, resourceId, startsWith)
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

        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.let {
            if (resourceType == null)
                resourceType = it.getIntExtra(IntentExtra.RESOURCE_TYPE.key, ResourceType.CHARACTER.ordinal)

            if (resourceId == null)
                resourceId = it.getIntExtra(IntentExtra.RESOURCE_ID.key, -1)

            var startsWith: String? = null
            if (Intent.ACTION_SEARCH == it.action)
                startsWith = it.getStringExtra(SearchManager.QUERY)

            if (resourceId != -1 || startsWith != null) {
                if (this::fragment.isInitialized)
                    fragment.refresh(startsWith)
                else
                    loadFragment(resourceType, resourceId, startsWith)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_search, menu)

        // Get the SearchView and set the searchable configuration
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = (menu?.findItem(R.id.action_search)?.actionView as SearchView).apply {
            // Assumes current activity is the searchable activity
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        if (resourceId == -1)
            searchView.isIconified = false

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