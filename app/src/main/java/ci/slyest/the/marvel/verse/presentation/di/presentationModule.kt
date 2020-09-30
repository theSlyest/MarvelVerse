package ci.slyest.the.marvel.verse.presentation.di

import ci.slyest.the.marvel.verse.domain.usecases.CharactersUseCase
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule: Module = module {

    viewModel { CharacterViewModel(useCase = get()) }
    single { CharactersUseCase() }

}