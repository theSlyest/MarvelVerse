package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Creator
import com.bumptech.glide.RequestManager


class CreatorViewHolder(itemView: View, glide: RequestManager)
    : IRecyclerViewHolder<Creator>(itemView, glide) {

    override fun bind(item: Creator) {
        with(item) {
            loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
            textName.text = "$lastName $suffix"
            textSecondary.text = "$firstName $middleName"
        }
    }
}
