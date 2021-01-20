package ci.slyest.the.marvel.verse.data.di

import ci.slyest.the.marvel.verse.data.remote.*
import ci.slyest.the.marvel.verse.data.repositories.*
import ci.slyest.the.marvel.verse.domain.repositories.*
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {

    single<CharacterRepository> { CharacterRepositoryImpl(characterSource = get()) }
    single { CharacterSource(characterService = MarvelModule.characterService()) }

    single<ComicRepository> { ComicRepositoryImpl(comicSource = get()) }
    single { ComicSource(comicService = MarvelModule.comicService()) }

    single<CreatorRepository> { CreatorRepositoryImpl(creatorSource = get()) }
    single { CreatorSource(creatorService = MarvelModule.creatorService()) }

    single<EventRepository> { EventRepositoryImpl(eventSource = get()) }
    single { EventSource(eventService = MarvelModule.eventService()) }

    single<SeriesRepository> { SeriesRepositoryImpl(seriesSource = get()) }
    single { SeriesSource(seriesService = MarvelModule.seriesService()) }

    single<StoryRepository> { StoryRepositoryImpl(storySource = get()) }
    single { StorySource(storyService = MarvelModule.storyService()) }
}