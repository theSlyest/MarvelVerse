package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Context
import android.os.Bundle
import android.text.method.LinkMovementMethod
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.ResourceHolder
import ci.slyest.the.marvel.verse.presentation.common.fromHtml
import ci.slyest.the.marvel.verse.presentation.common.setAttribution
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_character.*
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
            }
    }
}