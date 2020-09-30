package ci.slyest.the.marvel.verse.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.presentation.R


class CharacterAdapter: PagedListAdapter<Character, CharacterViewHolder>(ASYNC_DIFFER) {

    companion object {
        val ASYNC_DIFFER: AsyncDifferConfig<Character> = AsyncDifferConfig.Builder<Character>(
            object: DiffUtil.ItemCallback<Character?>() {
                override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean
                        = oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean
                        = oldItem == newItem
            }).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        if (character != null)
            holder.bind(character)
        else
            holder.clear()
    }
}