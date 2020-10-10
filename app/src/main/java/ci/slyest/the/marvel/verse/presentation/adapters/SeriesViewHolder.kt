package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.View
import ci.slyest.the.marvel.verse.domain.entities.Series
import com.bumptech.glide.RequestManager


class SeriesViewHolder(itemView: View, glide: RequestManager)
    : IRecyclerViewHolder<Series>(itemView, glide) {

    override fun bind(item: Series) {
        with(item) {
            loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
            textName.text = title
            textSecondary.text = "$startYear-$endYear"
        }
    }
}
