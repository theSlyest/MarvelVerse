package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.SimpleAdapter
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_story.*
import java.util.*

class StoryActivity: IDetailActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_story)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)
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
                            .into(img_thumbnail)
                    }
                    this@StoryActivity.title = title
                    text_title.text = title
                    text_id.text = id.toString()
                    text_rating.text = this.type

                    val creatorAdapter = SimpleAdapter(this@StoryActivity,
                        creators.items.map { creator ->
                            mapOf("role" to creator.role.capitalize(Locale.ROOT), "name" to creator.name)
                        },
                        R.layout.grid_item,
                        arrayOf("role", "name"),
                        intArrayOf(R.id.text_label, R.id.text_value))
                    grid_creators.adapter = creatorAdapter

                    text_description.text = if (description.isEmpty())
                        getString(R.string.msg_no_description)
                    else
                        fromHtml(description)
                }

                text_urls.movementMethod = LinkMovementMethod.getInstance()

                btn_characters.setOnClickListener {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra(IntentExtra.SOURCE_ID.key, story.id)
                    intent.putExtra(IntentExtra.SOURCE_TYPE.key, ResourceType.COMIC.ordinal)
                    intent.putExtra(IntentExtra.RESULT_TYPE.key, ResourceType.CHARACTER.ordinal)
                    startActivity(intent)
                }
            }
    }


}