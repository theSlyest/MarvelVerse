package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.activity_character.text_attribution
import kotlinx.android.synthetic.main.activity_character.toolbar
import java.util.*

class CharacterActivity : IDetailActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_character)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getCharacter()
            .let { character ->
                with(character) {
                    Glide.with(this@CharacterActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/standard_fantastic.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(img_thumbnail)

                    title = name.substringBefore('(')
                    text_title.text = title
                    text_secondary.text = name.substringAfter('(', "")
                        .substringBefore(')')
                    text_id.text = id.toString()
                    text_description.text = description.ifEmpty { getString(R.string.msg_no_description) }
                    var first = true
                    var strUrls = ""
                    character.urls.forEach { url ->
                        if (first)
                            first = false
                        else
                            strUrls += " | "

                        strUrls += "<a href=\"${url.url}\">${url.type.capitalize(Locale.ROOT)}</a>"
                    }
                    text_urls.text = fromHtml(strUrls)
                }

                text_urls.movementMethod = LinkMovementMethod.getInstance()

                btn_comics.setOnClickListener {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra(IntentExtra.SOURCE_ID.key, character.id)
                    intent.putExtra(IntentExtra.SOURCE_TYPE.key, ResourceType.CHARACTER.ordinal)
                    intent.putExtra(IntentExtra.RESULT_TYPE.key, ResourceType.COMIC.ordinal)
                    startActivity(intent)
                }
            }
    }
}