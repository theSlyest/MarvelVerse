package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.DataSource
import ci.slyest.the.marvel.verse.domain.entities.Comic
import ci.slyest.the.marvel.verse.presentation.viewmodels.ComicViewModel

class ComicDataSourceFactory(private val viewModel: ComicViewModel) : DataSource.Factory<Int, Comic>() {
    override fun create(): DataSource<Int, Comic> = ComicDataSource(viewModel)
}