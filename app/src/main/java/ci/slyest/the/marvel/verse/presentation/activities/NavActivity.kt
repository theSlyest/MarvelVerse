package ci.slyest.the.marvel.verse.presentation.activities

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.databinding.ActivityNavBinding
import ci.slyest.the.marvel.verse.presentation.databinding.AppBarNavBinding
import java.util.*


class NavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bindingBar = AppBarNavBinding.bind(binding.navView)
        setSupportActionBar(bindingBar.toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_characters, R.id.nav_comics, R.id.nav_stories, R.id.nav_events,
                R.id.nav_series, R.id.nav_creators
            ), binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        val textAttribution = binding.appBarInclude.contentInclude.textAttribution
        textAttribution.text =
            fromHtml(getString(R.string.attribution, Calendar.getInstance().get(Calendar.YEAR)))
        textAttribution.movementMethod = LinkMovementMethod.getInstance()

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_tabs, menu)

                // Get the SearchView and set the searchable configuration
                val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
                (menu.findItem(R.id.action_search)?.actionView as SearchView).apply {
                    // Assumes current activity is the searchable activity
                    setSearchableInfo(searchManager.getSearchableInfo(ComponentName(context, SearchActivity::class.java)))
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}