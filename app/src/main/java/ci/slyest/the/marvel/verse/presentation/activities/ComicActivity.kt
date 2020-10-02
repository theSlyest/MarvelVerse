package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.repositories.comicPagedList
import ci.slyest.the.marvel.verse.presentation.utils.fromHtml
import ci.slyest.the.marvel.verse.presentation.utils.setAttribution
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_comic.*
import java.util.*

private const val ARG_POSITION = "position"

class ComicActivity : AppCompatActivity() {

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        position = intent.getIntExtra(ARG_POSITION, 0)
        comicPagedList?.value
            ?.get(position)
            ?.let { comic ->
                with(comic) {
                    Glide.with(this@ComicActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/portrait_uncanny.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(img_thumbnail)

                    this@ComicActivity.title = title
                    text_title.text = title
                    text_id.text = id.toString()
                    text_format.text = format

                    val creatorAdapter = SimpleAdapter(this@ComicActivity,
                        creators.items.map { creator ->
                            mapOf("role" to creator.role.capitalize(Locale.ROOT), "name" to creator.name)
                        },
                        R.layout.grid_item,
                        arrayOf("role", "name"),
                        intArrayOf(R.id.text_label, R.id.text_value))
                    grid_creators.adapter = creatorAdapter

                    var first = true
                    var strUrls = ""
                    urls.forEach { url ->
                        if (first)
                            first = false
                        else
                            strUrls += " | "

                        strUrls += "<a href=\"${url.url}\">${url.type.capitalize(Locale.ROOT)}</a>"
                    }

                    text_urls.text = fromHtml(strUrls)
                    text_variant_description.text = fromHtml(variantDescription)
                    text_description.text = if (description.isNullOrEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                text_urls.movementMethod = LinkMovementMethod.getInstance()
            }
    }

    companion object {
        @JvmStatic
        fun start(context: Context, position: Int) =
            Intent(context, ComicActivity::class.java).let { intent ->
                intent.putExtra(ARG_POSITION, position)
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
}