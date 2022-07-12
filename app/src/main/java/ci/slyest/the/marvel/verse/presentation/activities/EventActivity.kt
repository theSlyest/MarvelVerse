package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import ci.slyest.the.marvel.verse.presentation.databinding.ActivityEventBinding
import com.bumptech.glide.Glide
import java.util.*

class EventActivity: IDetailActivity() {
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAttribution(this, binding.textAttribution)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getEvent()
            .let { event ->
                with(event) {
                    Glide.with(this@EventActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/standard_fantastic.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(binding.imgThumbnail)

                    this@EventActivity.title = title
                    binding.textTitle.text = title
                    binding.textId.text = id.toString()
                    if (!start.isNullOrEmpty() && !end.isNullOrEmpty())
                        binding.textSecondary.text = "${start!!.substring(0, 10)} - ${end!!.substring(0, 10)}"

                    val creatorAdapter = SimpleAdapter(this@EventActivity,
                        creators.items.map { creator ->
                            mapOf(
                                "role" to creator.role.replaceFirstChar { it.titlecase(Locale.ROOT) },
                                "name" to creator.name)
                        },
                        R.layout.grid_item,
                        arrayOf("role", "name"),
                        intArrayOf(R.id.text_label, R.id.text_value))
                    binding.gridCreators.adapter = creatorAdapter

                    var first = true
                    var strUrls = ""
                    urls.forEach { url ->
                        if (first)
                            first = false
                        else
                            strUrls += " | "

                        strUrls += "<a href=\"${url.url}\">${url.type.replaceFirstChar { it.titlecase(Locale.ROOT) }}</a>"
                    }

                    binding.textUrls.text = fromHtml(strUrls)
                    binding.textDescription.text = if (description.isEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                binding.textUrls.movementMethod = LinkMovementMethod.getInstance()

                binding.btnCharacters.setOnClickListener {
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.CHARACTER)
                }

                binding.btnComics.setOnClickListener {
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.COMIC)
                }

                binding.btnSeries.setOnClickListener {
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.SERIES)
                }

                binding.btnStories.setOnClickListener {
                    startResultsActivity(event.id, ResourceType.EVENT, ResourceType.STORY)
                }
            }
    }

}