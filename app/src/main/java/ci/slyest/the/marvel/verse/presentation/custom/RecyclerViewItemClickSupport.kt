package ci.slyest.the.marvel.verse.presentation.custom

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ci.slyest.the.marvel.verse.presentation.R

typealias OnRecyclerViewItemClickListener = (recyclerView: RecyclerView, position: Int, v: View) -> Unit
typealias OnRecyclerViewItemLongClickListener = (recyclerView: RecyclerView, position: Int, v: View) -> Boolean

/**
 * Adds ItemClickListener to RecyclerView
 *
 * Credits:
 * Hugo Visser (Java) https://www.littlerobots.nl/blog/Handle-Android-RecyclerView-Clicks/
 * Daniele Segato (Kotlin) https://stackoverflow.com/a/35917564/6135042
 */
class RecyclerViewItemClickSupport private constructor(private val recyclerView: RecyclerView) {

    private var onItemClickListener: OnRecyclerViewItemClickListener? = null
    private var onItemLongClickListener: OnRecyclerViewItemLongClickListener? = null

    private val attachListener: RecyclerView.OnChildAttachStateChangeListener
            = object : RecyclerView.OnChildAttachStateChangeListener {

        override fun onChildViewAttachedToWindow(view: View) {
            // every time a new child view is attached add click listeners to it
            val holder = this@RecyclerViewItemClickSupport.recyclerView.getChildViewHolder(view)
                .takeIf { it is ViewHolderItemClickSupport } as? ViewHolderItemClickSupport

            if (onItemClickListener != null && holder?.isClickable != false) {
                view.setOnClickListener(onClickListener)
            }

            if (onItemLongClickListener != null && holder?.isLongClickable != false) {
                view.setOnLongClickListener(onLongClickListener)
            }
        }

        override fun onChildViewDetachedFromWindow(view: View) {}
    }

    init {
        // the ID must be declared in XML, used to avoid
        // replacing the ItemClickSupport without removing
        // the old one from the RecyclerView
        this.recyclerView.setTag(R.id.item_click_support, this)
        this.recyclerView.addOnChildAttachStateChangeListener(attachListener)
    }

    companion object {
        fun addTo(view: RecyclerView): RecyclerViewItemClickSupport {
            // if there's already an ItemClickSupport attached
            // to this RecyclerView do not replace it, use it
            var support: RecyclerViewItemClickSupport? = view.getTag(R.id.item_click_support) as? RecyclerViewItemClickSupport
            if (support == null) {
                support = RecyclerViewItemClickSupport(view)
            }
            return support
        }

        fun removeFrom(view: RecyclerView): RecyclerViewItemClickSupport? {
            val support = view.getTag(R.id.item_click_support) as? RecyclerViewItemClickSupport
            support?.detach(view)
            return support
        }
    }

    private val onClickListener = View.OnClickListener { v ->
        val listener = onItemClickListener ?: return@OnClickListener
        // ask the RecyclerView for the viewHolder of this view.
        // then use it to get the position for the adapter
        val holder = this.recyclerView.getChildViewHolder(v)
        listener.invoke(this.recyclerView, holder.adapterPosition, v)
    }

    private val onLongClickListener = View.OnLongClickListener { v ->
        val listener = onItemLongClickListener ?: return@OnLongClickListener false
        val holder = this.recyclerView.getChildViewHolder(v)
        return@OnLongClickListener listener.invoke(this.recyclerView, holder.adapterPosition, v)
    }

    private fun detach(view: RecyclerView) {
        view.removeOnChildAttachStateChangeListener(attachListener)
        view.setTag(R.id.item_click_support, null)
    }

    fun onItemClick(listener: OnRecyclerViewItemClickListener?): RecyclerViewItemClickSupport {
        onItemClickListener = listener
        return this
    }

    fun onItemLongClick(listener: OnRecyclerViewItemLongClickListener?): RecyclerViewItemClickSupport {
        onItemLongClickListener = listener
        return this
    }
}

/** Give click-ability and long-click-ability control to the ViewHolder */
interface ViewHolderItemClickSupport {
    val isClickable: Boolean get() = true
    val isLongClickable: Boolean get() = true
}

// Extension functions
fun RecyclerView.addItemClickSupport(configuration: RecyclerViewItemClickSupport.() -> Unit = {})
        = RecyclerViewItemClickSupport.addTo(this).apply(configuration)

fun RecyclerView.removeItemClickSupport() = RecyclerViewItemClickSupport.removeFrom(this)

fun RecyclerView.onItemClick(onClick: OnRecyclerViewItemClickListener) {
    addItemClickSupport { onItemClick(onClick) }
}

fun RecyclerView.onItemLongClick(onLongClick: OnRecyclerViewItemLongClickListener) {
    addItemClickSupport { onItemLongClick(onLongClick) }
}