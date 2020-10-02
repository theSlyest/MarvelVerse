package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.repositories.characterPagedList
import ci.slyest.the.marvel.verse.presentation.utils.fromHtml
import ci.slyest.the.marvel.verse.presentation.utils.setAttribution
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_character.*
import java.util.*

private const val ARG_POSITION = "position"

class CharacterActivity : AppCompatActivity() {

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        setAttribution(this, text_attribution)

        setSupportActionBar(toolbar)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        position = intent.getIntExtra(ARG_POSITION, 0)
        characterPagedList?.value
            ?.get(position)
            ?.let { character ->
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

    companion object {
        @JvmStatic
        fun start(context: Context, position: Int) =
            Intent(context, CharacterActivity::class.java).let { intent ->
                intent.putExtra(ARG_POSITION, position)
                context.startActivity(intent)
            }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}