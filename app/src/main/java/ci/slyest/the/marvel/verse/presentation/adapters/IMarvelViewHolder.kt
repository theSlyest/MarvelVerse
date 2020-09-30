package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager

abstract class IMarvelViewHolder<T>(itemView: View, private val glide: RequestManager)
    : RecyclerView.ViewHolder(itemView) {

    protected var textName: TextView = itemView.findViewById(R.id.text_name)
    protected var textSecondary: TextView = itemView.findViewById(R.id.text_secondary)
    private var imgThumbnail: ImageView = itemView.findViewById(R.id.img_thumbnail)

    fun clear() {
        textName.text = null
        textSecondary.text = null
        glide.clear(imgThumbnail)
    }

    protected fun loadThumbnail(url: String) {
        glide.load(url.replace("http:", "https:"))
            .centerCrop()
            .placeholder(R.drawable.ic_marvel)
            .into(imgThumbnail)
    }

    abstract fun bind(item: T)
}