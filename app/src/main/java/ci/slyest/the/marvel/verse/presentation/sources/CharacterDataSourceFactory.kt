package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.DataSource
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel

class CharacterDataSourceFactory(private val viewModel: CharacterViewModel) : DataSource.Factory<Int, Character>() {
    override fun create(): DataSource<Int, Character> = CharacterDataSource(viewModel)
}