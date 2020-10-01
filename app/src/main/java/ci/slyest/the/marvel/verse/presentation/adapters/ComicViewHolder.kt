package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Comic
import com.bumptech.glide.RequestManager


class ComicViewHolder(itemView: View, glide: RequestManager)
    : IMarvelViewHolder<Comic>(itemView, glide) {

    override fun bind(item: Comic) {
        textName.text = item.title.substringBefore('#')
        textSecondary.text = if (item.title.indexOf('#') == -1)
            null
        else
            item.title.substring(item.title.indexOf('#'))

        loadThumbnail(item.thumbnail.path + "." + item.thumbnail.extension)
    }
}
