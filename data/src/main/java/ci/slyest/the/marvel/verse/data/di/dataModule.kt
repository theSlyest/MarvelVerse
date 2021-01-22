package ci.slyest.the.marvel.verse.data.di

import ci.slyest.the.marvel.verse.data.remote.*
import ci.slyest.the.marvel.verse.data.repositories.*
import ci.slyest.the.marvel.verse.domain.repositories.*
import org.koin.core.module.Module
import org.koin.dsl.module

/** Data module: dependency injection configuration. */
val dataModule: Module = module {

    /** [CharacterRepository] implementation: [CharacterRepositoryImpl] */
    single<CharacterRepository> { CharacterRepositoryImpl(characterSource = get()) }
    /** [CharacterSource] required by [CharacterRepositoryImpl] */
    single { CharacterSource(characterService = MarvelModule.characterService()) }

    /** [ComicRepository] implementation: [ComicRepositoryImpl] */
    single<ComicRepository> { ComicRepositoryImpl(comicSource = get()) }
    /** [ComicSource] required by [ComicRepositoryImpl] */
    single { ComicSource(comicService = MarvelModule.comicService()) }

    /** [CreatorRepository] implementation: [CreatorRepositoryImpl] */
    single<CreatorRepository> { CreatorRepositoryImpl(creatorSource = get()) }
    /** [CreatorSource] required by [CreatorRepositoryImpl] */
    single { CreatorSource(creatorService = MarvelModule.creatorService()) }

    /** [EventRepository] implementation: [EventRepositoryImpl] */
    single<EventRepository> { EventRepositoryImpl(eventSource = get()) }
    /** [EventSource] required by [EventRepositoryImpl] */
    single { EventSource(eventService = MarvelModule.eventService()) }

    /** [SeriesRepository] implementation: [SeriesRepositoryImpl] */
    single<SeriesRepository> { SeriesRepositoryImpl(seriesSource = get()) }
    /** [SeriesSource] required by [SeriesRepositoryImpl] */
    single { SeriesSource(seriesService = MarvelModule.seriesService()) }

    /** [StoryRepository] implementation: [StoryRepositoryImpl] */
    single<StoryRepository> { StoryRepositoryImpl(storySource = get()) }
    /** [StorySource] required by [StoryRepositoryImpl] */
    single { StorySource(storyService = MarvelModule.storyService()) }
}