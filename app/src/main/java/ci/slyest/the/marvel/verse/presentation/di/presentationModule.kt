package ci.slyest.the.marvel.verse.presentation.di

import ci.slyest.the.marvel.verse.domain.usecases.*
import ci.slyest.the.marvel.verse.presentation.viewmodels.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule: Module = module {

    single { CharactersUseCase() }
    viewModel { CharacterViewModel(useCase = get()) }
    viewModel { CharacterSearchViewModel(useCase = get()) }

    single { ComicsUseCase() }
    viewModel { ComicViewModel(useCase = get()) }
    viewModel { ComicSearchViewModel(useCase = get()) }

    single { CreatorsUseCase() }
    viewModel { CreatorViewModel(useCase = get()) }
    viewModel { CreatorSearchViewModel(useCase = get()) }

    single { EventsUseCase() }
    viewModel { EventViewModel(useCase = get()) }
    viewModel { EventSearchViewModel(useCase = get()) }

    single { SeriesUseCase() }
    viewModel { SeriesViewModel(useCase = get()) }
    viewModel { SeriesSearchViewModel(useCase = get()) }

    single { StoriesUseCase() }
    viewModel { StoryViewModel(useCase = get()) }
    viewModel { StorySearchViewModel(useCase = get()) }
}