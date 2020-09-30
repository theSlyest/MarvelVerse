package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Character
import com.bumptech.glide.RequestManager


class CharacterViewHolder(itemView: View, glide: RequestManager)
    : IMarvelViewHolder<Character>(itemView, glide) {

    override fun bind(item: Character) {
        textName.text = item.name.substringBefore('(')

        textSecondary.text = item.name.substringAfter('(', "")
            .substringBefore(')')

        loadThumbnail(item.thumbnail.path + "." + item.thumbnail.extension)
    }
}
