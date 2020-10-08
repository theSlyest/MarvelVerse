package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.PositionalDataSource
import io.reactivex.rxjava3.disposables.Disposable

abstract class IMarvelDataSource<T>: PositionalDataSource<T>() {

    protected var count: Int? = null
    protected lateinit var disposable: Disposable
    protected var waiting = false

    protected fun dispose() {
        waiting = false
        disposable.dispose()
    }
}