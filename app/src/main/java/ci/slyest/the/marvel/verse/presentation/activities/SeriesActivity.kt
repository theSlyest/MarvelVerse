package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import ci.slyest.the.marvel.verse.presentation.databinding.ActivitySeriesBinding
import com.bumptech.glide.Glide
import java.util.*

class SeriesActivity: IDetailActivity() {
    private lateinit var binding: ActivitySeriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAttribution(this, binding.textAttribution)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getSeries()
            .let { series ->
                with(series) {
                    Glide.with(this@SeriesActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/standard_fantastic.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(binding.imgThumbnail)

                    this@SeriesActivity.title = title
                    binding.textTitle.text = title
                    binding.textId.text = id.toString()
                    binding.textRating.text = this.rating
                    binding.textSecondary.text = if (startYear == endYear)
                        startYear.toString()
                    else
                        "$startYear - $endYear"

                    val creatorAdapter = SimpleAdapter(this@SeriesActivity,
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
                    binding.textDescription.text = if (description.isNullOrEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                binding.textUrls.movementMethod = LinkMovementMethod.getInstance()

                binding.btnCharacters.setOnClickListener {
                    startResultsActivity(series.id, ResourceType.SERIES, ResourceType.CHARACTER)
                }

                binding.btnComics.setOnClickListener {
                    startResultsActivity(series.id, ResourceType.SERIES, ResourceType.COMIC)
                }

                binding.btnStories.setOnClickListener {
                    startResultsActivity(series.id, ResourceType.SERIES, ResourceType.STORY)
                }

                binding.btnEvents.setOnClickListener {
                    startResultsActivity(series.id, ResourceType.SERIES, ResourceType.EVENT)
                }
            }
    }
}