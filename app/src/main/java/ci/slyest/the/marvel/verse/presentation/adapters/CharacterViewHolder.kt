package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Character
import com.bumptech.glide.RequestManager


class CharacterViewHolder(itemView: View, glide: RequestManager)
    : IRecyclerViewHolder<Character>(itemView, glide) {

    override fun bind(item: Character) {
        with(item) {
            loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
            textName.text = name.substringBefore('(')
            textSecondary.text = name.substringAfter('(', "")
                .substringBefore(')')
        }
    }
}
