package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.DataSource
import androidx.paging.PositionalDataSource
import io.reactivex.rxjava3.disposables.Disposable

abstract class IMarvelDataSource<T : Any>: PositionalDataSource<T>() {

    abstract class Factory<T : Any> : DataSource.Factory<Int, T>() {

        abstract val source: IMarvelDataSource<T>

        override fun create(): DataSource<Int, T> = source
    }

    protected var count: Int? = null
    protected lateinit var disposable: Disposable
    protected var waiting = false

    protected fun dispose() {
        waiting = false
        disposable.dispose()
    }
}