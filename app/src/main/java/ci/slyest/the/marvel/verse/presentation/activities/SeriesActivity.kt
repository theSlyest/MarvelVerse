package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_series.*
import java.util.*

class SeriesActivity: IDetailActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_series)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getSeries()
            .let { series ->
                with(series) {
                    Glide.with(this@SeriesActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/portrait_uncanny.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(img_thumbnail)

                    this@SeriesActivity.title = title
                    text_title.text = title
                    text_id.text = id.toString()
                    text_rating.text = this.rating

                    val creatorAdapter = SimpleAdapter(this@SeriesActivity,
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
                    text_description.text = if (description.isEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                text_urls.movementMethod = LinkMovementMethod.getInstance()

                btn_characters.setOnClickListener {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra(IntentExtra.SOURCE_ID.key, series.id)
                    intent.putExtra(IntentExtra.SOURCE_TYPE.key, ResourceType.COMIC.ordinal)
                    intent.putExtra(IntentExtra.RESULT_TYPE.key, ResourceType.CHARACTER.ordinal)
                    startActivity(intent)
                }
            }
    }
}