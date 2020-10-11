package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Event
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager

class EventAdapter(private val glide: RequestManager) :
    PagedListAdapter<Event, EventAdapter.ViewHolder>(ASYNC_DIFFER) {

    class ViewHolder(itemView: View, glide: RequestManager)
        : IRecyclerViewHolder<Event>(itemView, glide) {

        override fun bind(item: Event) {
            with(item) {
                loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
                textName.text = title
                if (!start.isNullOrEmpty())
                    textSecondary.text = "${start!!.substring(0, 10)}"
            }
        }
    }

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Event> = AsyncDifferConfig.Builder<Event>(
            object: DiffUtil.ItemCallback<Event?>() {
                override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = getItem(position)
        if (event != null)
            holder.bind(event)
        else
            holder.clear()
    }
}
