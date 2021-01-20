package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager

class CreatorAdapter(private val glide: RequestManager) :
    PagedListAdapter<Creator, CreatorAdapter.ViewHolder>(ASYNC_DIFFER) {

    class ViewHolder(itemView: View, glide: RequestManager)
        : IRecyclerViewHolder<Creator>(itemView, glide) {

        override fun bind(item: Creator) {
            with(item) {
                loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
                textName.text = "$lastName $suffix"
                textSecondary.text = "$firstName $middleName"
            }
        }
    }

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Creator> = AsyncDifferConfig.Builder<Creator>(
            object: DiffUtil.ItemCallback<Creator?>() {
                override fun areItemsTheSame(oldItem: Creator, newItem: Creator): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Creator, newItem: Creator): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val creator = getItem(position)
        if (creator != null)
            holder.bind(creator)
        else
            holder.clear()
    }
}
