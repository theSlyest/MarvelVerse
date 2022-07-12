package ci.slyest.the.marvel.verse.presentation.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.ResourceType
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import ci.slyest.the.marvel.verse.presentation.databinding.ActivityStoryBinding
import com.bumptech.glide.Glide
import java.util.*

class StoryActivity: IDetailActivity() {
    private lateinit var binding: ActivityStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAttribution(this, binding.textAttribution)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getStory()
            .let { story ->
                with(story) {
                    thumbnail?.let {
                        Glide.with(this@StoryActivity)
                            .load(it.path.replace("http:", "https:")
                                    + "/portrait_uncanny.${it.extension}")
                            .centerCrop()
                            .placeholder(R.drawable.ic_marvel)
                            .into(binding.imgThumbnail)
                    }
                    this@StoryActivity.title = title
                    binding.textTitle.text = title
                    binding.textId.text = id.toString()
                    binding.textRating.text = this.type

                    val creatorAdapter = SimpleAdapter(this@StoryActivity,
                        creators.items.map { creator ->
                            mapOf("role" to creator.role.replaceFirstChar { it.titlecase(Locale.ROOT) }, "name" to creator.name)
                        },
                        R.layout.grid_item,
                        arrayOf("role", "name"),
                        intArrayOf(R.id.text_label, R.id.text_value))
                    binding.gridCreators.adapter = creatorAdapter

                    binding.textDescription.text = if (description.isEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                binding.textUrls.movementMethod = LinkMovementMethod.getInstance()

                binding.btnCharacters.setOnClickListener {
                    startResultsActivity(story.id, ResourceType.STORY, ResourceType.CHARACTER)
                }

                binding.btnComics.setOnClickListener {
                    startResultsActivity(story.id, ResourceType.STORY, ResourceType.COMIC)
                }

                binding.btnEvents.setOnClickListener {
                    startResultsActivity(story.id, ResourceType.STORY, ResourceType.EVENT)
                }

                binding.btnSeries.setOnClickListener {
                    startResultsActivity(story.id, ResourceType.STORY, ResourceType.SERIES)
                }
            }
    }

}