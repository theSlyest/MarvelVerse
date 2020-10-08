package ci.slyest.the.marvel.verse.presentation.fragments

import android.os.Bundle
import ci.slyest.the.marvel.verse.presentation.common.IntentExtra

abstract class ISearchFragment: IRecyclerFragment() {

    protected var resourceType: Int = -1
    protected var resourceId: Int = -1
    protected var startsWith: String? = null

    companion object {
        @JvmStatic
        fun create(fragment: ISearchFragment, resourceType: Int? = null, resourceId: Int? = null, startsWith: String? = null) =
            fragment.apply {
                arguments = Bundle().apply {
                    resourceType?.let { putInt(IntentExtra.RESOURCE_TYPE.name, it) }
                    resourceId?.let { putInt(IntentExtra.RESOURCE_ID.name, it) }
                    startsWith?.let { putString(IntentExtra.STARTS_WITH.name, it) }
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            resourceType = bundle.getInt(IntentExtra.RESOURCE_TYPE.name,  -1)
            resourceId = bundle.getInt(IntentExtra.RESOURCE_ID.name, -1)
            startsWith = bundle.getString(IntentExtra.STARTS_WITH.name)
        }
    }

    abstract fun refresh(startsWith: String? = null)
}