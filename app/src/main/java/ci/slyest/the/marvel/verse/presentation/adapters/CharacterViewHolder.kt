package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager


class CharacterViewHolder(itemView: View, private val glide: RequestManager)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var textName: TextView = itemView.findViewById(R.id.text_name)
    private var textSecondary: TextView = itemView.findViewById(R.id.text_secondary)
    private var imgThumbnail: ImageView = itemView.findViewById(R.id.img_thumbnail)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(character: Character) {
        textName.text = character.name.substringBefore('(')

        textSecondary.text = character.name.substringAfter('(', "")
            .substringBefore(')')

        glide
            .load(character.thumbnail.path.replace("http:", "https:")
                    + "." + character.thumbnail.extension)
            .centerCrop()
            .placeholder(R.drawable.ic_marvel)
            .into(imgThumbnail)
    }

    fun clear() {
        textName.text = null
        textSecondary.text = null
        glide.clear(imgThumbnail)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
