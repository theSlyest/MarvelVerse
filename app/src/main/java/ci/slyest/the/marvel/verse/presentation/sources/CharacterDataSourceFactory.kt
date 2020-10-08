package ci.slyest.the.marvel.verse.presentation.sources

import androidx.paging.DataSource
import ci.slyest.the.marvel.verse.domain.entities.Character
import ci.slyest.the.marvel.verse.presentation.viewmodels.ICharacterViewModel

class CharacterDataSourceFactory(private val viewModel: ICharacterViewModel) : DataSource.Factory<Int, Character>() {

    val source = CharacterDataSource(viewModel)

    override fun create(): DataSource<Int, Character> = source
}