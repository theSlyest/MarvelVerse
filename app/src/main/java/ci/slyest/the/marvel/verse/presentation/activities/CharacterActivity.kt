package ci.slyest.the.marvel.verse.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.repositories.characterPagedList
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_character.*
import java.util.*

private const val ARG_POSITION = "position"

class CharacterActivity : AppCompatActivity() {

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        setSupportActionBar(toolbar)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        position = intent.getIntExtra(ARG_POSITION, 0)
        characterPagedList?.value
            ?.get(position)
            ?.let { character ->
                Glide.with(this)
                    .load(character.thumbnail.path.replace("http:", "https:")
                            + "." + character.thumbnail.extension)
                    .centerCrop()
                    .placeholder(R.drawable.ic_marvel)
                    .into(img_thumbnail)

                title = character.name.substringBefore('(')
                text_name.text = title
                text_secondary.text = character.name.substringAfter('(', "")
                    .substringBefore(')')
                text_id.text = position.toString()
                text_description.text = character.description.ifEmpty { getString(R.string.msg_no_description) }
                var first = true
                var strUrls = ""
                character.urls.forEach { url ->
                    if (first)
                        first = false
                    else
                        strUrls += " | "

                    strUrls += "<a href=\"${url.url}\">${url.type.capitalize(Locale.ROOT)}</a>"
                }

                text_urls.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    Html.fromHtml(strUrls, Html.FROM_HTML_MODE_LEGACY)
                else
                    Html.fromHtml(strUrls)

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

}