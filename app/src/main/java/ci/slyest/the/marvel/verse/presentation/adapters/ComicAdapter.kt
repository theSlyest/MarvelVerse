package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager


class ComicAdapter(private val glide: RequestManager): PagedListAdapter<Comic, ComicAdapter.ViewHolder>(ASYNC_DIFFER) {

    class ViewHolder(itemView: View, glide: RequestManager)
        : IRecyclerViewHolder<Comic>(itemView, glide) {

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

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Comic> = AsyncDifferConfig.Builder<Comic>(
            object: DiffUtil.ItemCallback<Comic?>() {
                override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = getItem(position)
        if (comic != null)
            holder.bind(comic)
        else
            holder.clear()
    }
}
