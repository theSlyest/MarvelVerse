package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.repositories.comicPagedList
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_comic.*
import java.util.*

private const val ARG_POSITION = "position"

class ComicActivity : AppCompatActivity() {

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic)

        setSupportActionBar(toolbar)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        position = intent.getIntExtra(ARG_POSITION, 0)
        comicPagedList?.value
            ?.get(position)
            ?.let { comic ->
                Glide.with(this)
                    .load(comic.thumbnail.path.replace("http:", "https:")
                            + "." + comic.thumbnail.extension)
                    .centerCrop()
                    .placeholder(R.drawable.ic_marvel)
                    .into(img_thumbnail)

                title = comic.title
                text_title.text = title
                text_id.text = comic.id.toString()
                text_description.text = if (comic.description.isNullOrEmpty())
                    getString(R.string.msg_no_description)
                else
                    comic.description
                text_variant_description.text = comic.variantDescription
                text_format.text = comic.format

                val dateAdapter = SimpleAdapter(this,
                    comic.dates.mapNotNull { date ->
                        if (date.date.startsWith("-"))
                            null
                        else
                            mapOf(
                                "type" to date.type.substringBefore("Date"),
                                "date" to date.date.substringBefore('T'))
                    },
                    R.layout.grid_item,
                    arrayOf("type", "date"),
                    intArrayOf(R.id.text_label, R.id.text_value))
                grid_dates.adapter = dateAdapter

                val creatorAdapter = SimpleAdapter(this,
                    comic.creators.items.map { creator ->
                        mapOf("role" to creator.role, "name" to creator.name)
                    },
                    R.layout.grid_item,
                    arrayOf("role", "name"),
                    intArrayOf(R.id.text_label, R.id.text_value))
                grid_creators.adapter = creatorAdapter

                var first = true
                var strUrls = ""
                comic.urls.forEach { url ->
                    if (first)
                        first = false
                    else
                        strUrls += " | "

                    strUrls += "<a href=\"${url.url}\">${url.type.capitalize(Locale.ROOT)}</a>"
                }

                text_urls.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    Html.fromHtml(strUrls, Html.FROM_HTML_MODE_LEGACY)
                else
                    Html.fromHtml(strUrls)

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

}