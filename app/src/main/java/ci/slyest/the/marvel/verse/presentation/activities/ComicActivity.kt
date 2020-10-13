package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_comic.*
import kotlinx.android.synthetic.main.activity_comic.btn_series
import kotlinx.android.synthetic.main.activity_comic.btn_stories
import kotlinx.android.synthetic.main.activity_comic.img_thumbnail
import kotlinx.android.synthetic.main.activity_comic.text_attribution
import kotlinx.android.synthetic.main.activity_comic.text_description
import kotlinx.android.synthetic.main.activity_comic.text_id
import kotlinx.android.synthetic.main.activity_comic.text_title
import kotlinx.android.synthetic.main.activity_comic.text_urls
import kotlinx.android.synthetic.main.activity_comic.toolbar
import java.util.*

class ComicActivity: IDetailActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_comic)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getComic()
            .let { comic ->
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
                    text_rating.text = format

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
                    text_dates.text = fromHtml(variantDescription)
                    text_description.text = if (description.isNullOrEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                text_urls.movementMethod = LinkMovementMethod.getInstance()

                btn_characters.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.CHARACTER)
                }

                btn_events.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.EVENT)
                }

                btn_stories.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.STORY)
                }

                btn_series.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.SERIES)
                }
            }
    }
}