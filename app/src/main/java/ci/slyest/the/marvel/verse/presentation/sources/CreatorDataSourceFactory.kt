package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.DataSource
import ci.slyest.the.marvel.verse.domain.entities.Creator
import ci.slyest.the.marvel.verse.presentation.viewmodels.ICreatorViewModel

class CreatorDataSourceFactory(private val viewModel: ICreatorViewModel) : DataSource.Factory<Int, Creator>() {

    val source = CreatorDataSource(viewModel)

    override fun create(): DataSource<Int, Creator> = source
}