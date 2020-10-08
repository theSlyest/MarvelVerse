package ci.slyest.the.marvel.verse.presentation.common

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.TextView
import ci.slyest.the.marvel.verse.presentation.R
import java.util.*

fun fromHtml(content: String?): Spanned =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(content)
    }

fun setAttribution(context: Context, textView: TextView) {
    textView.text = fromHtml(context.getString(R.string.attribution, Calendar.getInstance().get(Calendar.YEAR)))
    textView.movementMethod = LinkMovementMethod.getInstance()
}