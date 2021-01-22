package ci.slyest.the.marvel.verse.presentation.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.GridView

/** This custom GridView will adjust its own height to show all its rows. */
class AutoHeightGridView : GridView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Calculate entire height by providing a very large height hint.
        // View.MEASURED_SIZE_MASK represents the largest height possible.
        super.onMeasure(widthMeasureSpec,
            MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK, MeasureSpec.AT_MOST))
        layoutParams.height = measuredHeight
    }
}