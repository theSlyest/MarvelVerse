package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import ci.slyest.the.marvel.verse.presentation.databinding.ActivityCharacterBinding
import com.bumptech.glide.Glide
import java.util.*

class CharacterActivity : IDetailActivity() {
    private lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAttribution(this, binding.textAttribution)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getCharacter()
            .let { character ->
                with(character) {
                    Glide.with(this@CharacterActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/standard_fantastic.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(binding.imgThumbnail)

                    title = name.substringBefore('(')
                    binding.textTitle.text = title
                    binding.textSecondary.text = name.substringAfter('(', "")
                        .substringBefore(')')
                    binding.textId.text = id.toString()
                    binding.textDescription.text = description.ifEmpty { getString(R.string.msg_no_description) }
                    var first = true
                    var strUrls = ""
                    character.urls.forEach { url ->
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
                   startResultsActivity(character.id, ResourceType.CHARACTER, ResourceType.COMIC)
                }

                binding.btnEvents.setOnClickListener {
                    startResultsActivity(character.id, ResourceType.CHARACTER, ResourceType.EVENT)
                }

                binding.btnStories.setOnClickListener {
                    startResultsActivity(character.id, ResourceType.CHARACTER, ResourceType.STORY)
                }

                binding.btnSeries.setOnClickListener {
                    startResultsActivity(character.id, ResourceType.CHARACTER, ResourceType.SERIES)
                }
            }
    }
}