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
import ci.slyest.the.marvel.verse.presentation.fragments.*
import kotlinx.android.synthetic.main.app_bar_nav.*

class SearchActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var fragment: ISearchFragment
    private var resultType: Int? = null
    private var sourceType: Int? = null
    private var sourceId: Int? = null
    private var startsWith: String? = null

    private fun loadFragment(resultType: Int? = null, sourceType: Int? = null, sourceId: Int? = null,
                             startsWith: String? = null) {
        fragment = when(resultType) {
            ResourceType.CHARACTER.ordinal ->
                CharacterSearchFragment.create(sourceType, sourceId, startsWith)
            ResourceType.COMIC.ordinal ->
                ComicSearchFragment.create(sourceType, sourceId, startsWith)
            ResourceType.EVENT.ordinal ->
                EventSearchFragment.create(sourceType, sourceId, startsWith)
            ResourceType.STORY.ordinal ->
                StorySearchFragment.create(sourceType, sourceId, startsWith)
            ResourceType.SERIES.ordinal ->
                SeriesSearchFragment.create(sourceType, sourceId, startsWith)
            ResourceType.CREATOR.ordinal ->
                CreatorSearchFragment.create(sourceType, sourceId, startsWith)
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
            if (resultType == null)
                resultType = it.getIntExtra(IntentExtra.RESULT_TYPE.key, ResourceType.CHARACTER.ordinal)

            if (sourceType == null)
                sourceType = it.getIntExtra(IntentExtra.SOURCE_TYPE.key, ResourceType.CHARACTER.ordinal)

            if (sourceId == null)
                sourceId = it.getIntExtra(IntentExtra.SOURCE_ID.key, -1)

            if (Intent.ACTION_SEARCH == it.action)
                startsWith = it.getStringExtra(SearchManager.QUERY)

            if (sourceId != -1 || startsWith != null) {
                if (this::fragment.isInitialized)
                    fragment.refresh(startsWith)
                else
                    loadFragment(resultType, sourceType, sourceId, startsWith)
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

        if (sourceId == -1)
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