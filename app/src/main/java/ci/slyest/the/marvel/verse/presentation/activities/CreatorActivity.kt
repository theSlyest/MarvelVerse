package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.common.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_creator.*
import kotlinx.android.synthetic.main.activity_creator.text_attribution
import kotlinx.android.synthetic.main.activity_creator.toolbar
import java.util.*

class CreatorActivity : IDetailActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_creator)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ResourceHolder.getCreator()
            .let { creator ->
                with(creator) {
                    Glide.with(this@CreatorActivity)
                        .load(thumbnail.path.replace("http:", "https:")
                                + "/standard_fantastic.${thumbnail.extension}")
                        .centerCrop()
                        .placeholder(R.drawable.ic_marvel)
                        .into(img_thumbnail)

                    title = fullName
                    text_title.text = "$lastName $suffix"
                    text_secondary.text = "$firstName $middleName"
                    text_id.text = id.toString()
                    var first = true
                    var strUrls = ""
                    creator.urls.forEach { url ->
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
                    intent.putExtra(IntentExtra.SOURCE_ID.key, creator.id)
                    intent.putExtra(IntentExtra.SOURCE_TYPE.key, ResourceType.CREATOR.ordinal)
                    intent.putExtra(IntentExtra.RESULT_TYPE.key, ResourceType.COMIC.ordinal)
                    startActivity(intent)
                }
            }
    }
}