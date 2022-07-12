package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import ci.slyest.the.marvel.verse.presentation.databinding.ActivityCreatorBinding
import com.bumptech.glide.Glide
import java.util.*

class CreatorActivity : IDetailActivity() {
    private lateinit var binding: ActivityCreatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAttribution(this, binding.textAttribution)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getCreator()
            .let { creator ->
                with(creator) {
                    Glide.with(this@CreatorActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/standard_fantastic.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(binding.imgThumbnail)

                    title = fullName
                    binding.textTitle.text = "$lastName $suffix"
                    binding.textSecondary.text = "$firstName $middleName"
                    binding.textId.text = id.toString()
                    var first = true
                    var strUrls = ""
                    creator.urls.forEach { url ->
                        if (first)
                            first = false
                        else
                            strUrls += " | "

                        strUrls += "<a href=\"${url.url}\">${url.type.replaceFirstChar { it.titlecase(Locale.ROOT) }}</a>"
                    }
                    binding.textUrls.text = fromHtml(strUrls)
                }

                binding.textUrls.movementMethod = LinkMovementMethod.getInstance()

                binding.btnComics.setOnClickListener {
                    startResultsActivity(creator.id, ResourceType.CREATOR, ResourceType.COMIC)
                }

                binding.btnEvents.setOnClickListener {
                    startResultsActivity(creator.id, ResourceType.CREATOR, ResourceType.EVENT)
                }

                binding.btnStories.setOnClickListener {
                    startResultsActivity(creator.id, ResourceType.CREATOR, ResourceType.STORY)
                }

                binding.btnSeries.setOnClickListener {
                    startResultsActivity(creator.id, ResourceType.CREATOR, ResourceType.SERIES)
                }
            }
    }
}