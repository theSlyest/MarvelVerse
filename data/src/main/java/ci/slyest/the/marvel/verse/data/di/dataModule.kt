package ci.slyest.the.marvel.verse.data.di

import ci.slyest.the.marvel.verse.data.remote.MarvelModule
import ci.slyest.the.marvel.verse.data.remote.CharacterSource
import ci.slyest.the.marvel.verse.data.remote.ComicSource
import ci.slyest.the.marvel.verse.data.remote.StorySource
import ci.slyest.the.marvel.verse.data.repositories.CharacterRepositoryImpl
import ci.slyest.the.marvel.verse.data.repositories.ComicRepositoryImpl
import ci.slyest.the.marvel.verse.data.repositories.StoryRepositoryImpl
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import ci.slyest.the.marvel.verse.domain.repositories.StoryRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {

    single<CharacterRepository> { CharacterRepositoryImpl(characterSource = get()) }
    single { CharacterSource(characterService = MarvelModule.characterService()) }

    single<ComicRepository> { ComicRepositoryImpl(comicSource = get()) }
    single { ComicSource(comicService = MarvelModule.comicService()) }

    single<StoryRepository> { StoryRepositoryImpl(storySource = get()) }
    single { StorySource(storyService = MarvelModule.storyService()) }
}