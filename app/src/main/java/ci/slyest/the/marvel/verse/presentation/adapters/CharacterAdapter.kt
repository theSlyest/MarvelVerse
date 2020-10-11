package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.presentation.R
import com.bumptech.glide.RequestManager

class CharacterAdapter(private val glide: RequestManager) :
    PagedListAdapter<Character, CharacterAdapter.ViewHolder>(ASYNC_DIFFER) {

    class ViewHolder(itemView: View, glide: RequestManager)
        : IRecyclerViewHolder<Character>(itemView, glide) {

        override fun bind(item: Character) {
            with(item) {
                loadThumbnail("${thumbnail.path}/standard_fantastic.${thumbnail.extension}")
                textName.text = name.substringBefore('(')
                textSecondary.text = name.substringAfter('(', "")
                    .substringBefore(')')
            }
        }
    }

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Character> = AsyncDifferConfig.Builder<Character>(
            object: DiffUtil.ItemCallback<Character?>() {
                override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)
        if (character != null)
            holder.bind(character)
        else
            holder.clear()
    }
}
