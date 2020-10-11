package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Story
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager

class StoryAdapter(private val glide: RequestManager): PagedListAdapter<Story, StoryAdapter.ViewHolder>(ASYNC_DIFFER) {

    class ViewHolder(itemView: View, glide: RequestManager)
        : IRecyclerViewHolder<Story>(itemView, glide) {

        override fun bind(item: Story) {
            with(item) {
                thumbnail?.let {
                    loadThumbnail("${it.path}/standard_fantastic.${it.extension}")
                }
                textName.text = title
                textSecondary.text = type
            }
        }
    }

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Story> = AsyncDifferConfig.Builder<Story>(
            object: DiffUtil.ItemCallback<Story?>() {
                override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val story = getItem(position)
        if (story != null)
            holder.bind(story)
        else
            holder.clear()
    }
}
