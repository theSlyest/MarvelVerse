package ci.slyest.the.marvel.verse.presentation.common

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.TextView
import ci.slyest.the.marvel.verse.presentation.R
import java.util.*

/**
 * Perform the right HTML conversion according to the current OS.
 * @param content [String] containing HTML code.
 * @return [Spanned] displayable text.
 */
fun fromHtml(content: String?): Spanned =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(content)
    }

/**
 * Insert Marvel attribution text in the given [TextView].
 * @param context [Context] of the TextView.
 * @param textView [TextView] used to display Marvel Attribution text.
 */
fun setAttribution(context: Context, textView: TextView) {
    textView.text = fromHtml(context.getString(R.string.attribution, Calendar.getInstance().get(Calendar.YEAR)))
    textView.movementMethod = LinkMovementMethod.getInstance()
}