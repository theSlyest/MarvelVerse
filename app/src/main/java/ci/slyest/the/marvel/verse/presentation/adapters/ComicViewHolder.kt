package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Comic
import com.bumptech.glide.RequestManager


class ComicViewHolder(itemView: View, glide: RequestManager)
    : IMarvelViewHolder<Comic>(itemView, glide) {

    override fun bind(item: Comic) {
        with(item) {
            loadThumbnail("${thumbnail.path}/portrait_uncanny.${thumbnail.extension}")
            textName.text = title.substringBefore('#')
            textSecondary.text = if (title.indexOf('#') == -1)
                null
            else
                title.substring(title.indexOf('#'))
        }
    }
}
