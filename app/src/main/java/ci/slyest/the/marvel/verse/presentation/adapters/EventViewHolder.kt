package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Event
import com.bumptech.glide.RequestManager


class EventViewHolder(itemView: View, glide: RequestManager)
    : IRecyclerViewHolder<Event>(itemView, glide) {

    override fun bind(item: Event) {
        with(item) {
            loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
            textName.text = title
            textSecondary.text = "${start.substringBefore('T')} - ${end.substringBefore('T')}"
        }
    }
}
