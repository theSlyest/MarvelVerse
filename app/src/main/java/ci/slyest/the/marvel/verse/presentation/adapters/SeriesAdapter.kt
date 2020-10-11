package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Series
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager

class SeriesAdapter(private val glide: RequestManager) :
    PagedListAdapter<Series, SeriesAdapter.ViewHolder>(ASYNC_DIFFER) {

    class ViewHolder(itemView: View, glide: RequestManager)
        : IRecyclerViewHolder<Series>(itemView, glide) {

        override fun bind(item: Series) {
            with(item) {
                loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
                textName.text = title
                textSecondary.text = if (startYear == endYear)
                    startYear.toString()
                else
                    "$startYear - $endYear"
            }
        }
    }

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Series> = AsyncDifferConfig.Builder<Series>(
            object: DiffUtil.ItemCallback<Series?>() {
                override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val series = getItem(position)
        if (series != null)
            holder.bind(series)
        else
            holder.clear()
    }
}
