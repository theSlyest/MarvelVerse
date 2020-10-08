package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class IDetailActivity: AppCompatActivity() {

    protected var position = 0
    protected var search = false

    companion object {
        private const val ARG_POSITION = "ci.slyest.the.marvel.verse.presentation.position"
        private const val ARG_SEARCH = "ci.slyest.the.marvel.verse.presentation.search"

        @JvmStatic
        fun start(context: Context, position: Int, search: Boolean, cls: Class<*>) =
            Intent(context, cls).let { intent ->
                intent.putExtra(ARG_POSITION, position)
                intent.putExtra(ARG_SEARCH, search)
                context.startActivity(intent)
            }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = intent.getIntExtra(ARG_POSITION, 0)
        search = intent.getBooleanExtra(ARG_SEARCH, false)
    }
}