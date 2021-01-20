package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.*
import ci.slyest.the.marvel.verse.presentation.databinding.ActivityComicBinding
import com.bumptech.glide.Glide
import java.util.*

class ComicActivity: IDetailActivity() {
    private lateinit var binding: ActivityComicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAttribution(this, binding.textAttribution)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getComic()
            .let { comic ->
                with(comic) {
                    Glide.with(this@ComicActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/portrait_uncanny.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(binding.imgThumbnail)

                    this@ComicActivity.title = title
                    binding.textTitle.text = title
                    binding.textId.text = id.toString()
                    binding.textRating.text = format

                    val creatorAdapter = SimpleAdapter(this@ComicActivity,
                        creators.items.map { creator ->
                            mapOf("role" to creator.role.capitalize(Locale.ROOT), "name" to creator.name)
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

                        strUrls += "<a href=\"${url.url}\">${url.type.capitalize(Locale.ROOT)}</a>"
                    }

                    binding.textUrls.text = fromHtml(strUrls)
                    binding.textDates.text = fromHtml(variantDescription)
                    binding.textDescription.text = if (description.isNullOrEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                binding.textUrls.movementMethod = LinkMovementMethod.getInstance()

                binding.btnCharacters.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.CHARACTER)
                }

                binding.btnEvents.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.EVENT)
                }

                binding.btnStories.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.STORY)
                }

                binding.btnSeries.setOnClickListener {
                    startResultsActivity(comic.id, ResourceType.CHARACTER, ResourceType.SERIES)
                }
            }
    }
}