package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Series
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager

class SeriesAdapter(private val glide: RequestManager): PagedListAdapter<Series, SeriesViewHolder>(ASYNC_DIFFER) {

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Series> = AsyncDifferConfig.Builder<Series>(
            object: DiffUtil.ItemCallback<Series?>() {
                override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return SeriesViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val series = getItem(position)
        if (series != null)
            holder.bind(series)
        else
            holder.clear()
    }
}
