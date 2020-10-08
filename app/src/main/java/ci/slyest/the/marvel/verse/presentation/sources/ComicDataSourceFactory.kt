package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.DataSource
import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.presentation.viewmodels.IComicViewModel

class ComicDataSourceFactory(private val viewModel: IComicViewModel) : DataSource.Factory<Int, Comic>() {

    val source = ComicDataSource(viewModel)

    override fun create(): DataSource<Int, Comic> = source
}