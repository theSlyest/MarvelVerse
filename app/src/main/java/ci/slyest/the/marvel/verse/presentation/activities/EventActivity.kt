package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_event.*
import java.util.*

class EventActivity: IDetailActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_event)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getEvent()
            .let { event ->
                with(event) {
                    Glide.with(this@EventActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/standard_fantastic.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(img_thumbnail)

                    this@EventActivity.title = title
                    text_title.text = title
                    text_id.text = id.toString()
                    if (!start.isNullOrEmpty() && !end.isNullOrEmpty())
                        text_secondary.text = "${start!!.substring(0, 10)} - ${end!!.substring(0, 10)}"

                    val creatorAdapter = SimpleAdapter(this@EventActivity,
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
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.CHARACTER)
                }

                btn_comics.setOnClickListener {
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.COMIC)
                }

                btn_series.setOnClickListener {
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.SERIES)
                }

                btn_stories.setOnClickListener {
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.STORY)
                }
            }
    }


}