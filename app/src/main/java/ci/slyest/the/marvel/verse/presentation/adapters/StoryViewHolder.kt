package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Story
import com.bumptech.glide.RequestManager


class StoryViewHolder(itemView: View, glide: RequestManager)
    : IRecyclerViewHolder<Story>(itemView, glide) {

    override fun bind(item: Story) {
        with(item) {
            loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
            textName.text = title
            textSecondary.text = type
        }
    }
}
