package ci.slyest.the.marvel.verse.data.di

import ci.slyest.the.marvel.verse.data.remote.MarvelModule
import ci.slyest.the.marvel.verse.data.remote.CharacterSource
import ci.slyest.the.marvel.verse.data.remote.ComicSource
import ci.slyest.the.marvel.verse.data.repositories.CharacterRepositoryImpl
import ci.slyest.the.marvel.verse.data.repositories.ComicRepositoryImpl
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import ci.slyest.the.marvel.verse.domain.repositories.ComicRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {

    single<CharacterRepository> { CharacterRepositoryImpl(characterSource = get()) }
    single { CharacterSource(marvelService = MarvelModule.service()) }

    single<ComicRepository> { ComicRepositoryImpl(comicSource = get()) }
    single { ComicSource(marvelService = MarvelModule.service()) }
}