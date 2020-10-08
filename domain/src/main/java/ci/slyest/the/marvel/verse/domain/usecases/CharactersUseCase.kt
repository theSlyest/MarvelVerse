package ci.slyest.the.marvel.verse.domain.usecases

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

class CharactersUseCase : KoinComponent {

    private val characterRepository: CharacterRepository by inject()

    operator fun invoke(
        comicId: Int? = null,
        eventId: Int? = null,
        seriesId: Int? = null,
        storyId: Int? = null,
        name: String? = null,
        nameStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: String? = null,
        series: String? = null,
        events: String? = null,
        stories: String? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Single<CharacterDataWrapper> =
        when {
            comicId != null ->
                characterRepository.comicCharacters(comicId, name, nameStartsWith, modifiedSince,
                    series, events, stories, orderBy, limit, offset)
            eventId != null ->
                characterRepository.eventCharacters(eventId, name, nameStartsWith, modifiedSince,
                    comics, series, stories, orderBy, limit, offset)
            seriesId != null ->
                characterRepository.seriesCharacters(seriesId, name, nameStartsWith, modifiedSince,
                    comics, events, stories, orderBy, limit, offset)
            storyId != null ->
                characterRepository.storyCharacters(storyId, name, nameStartsWith, modifiedSince,
                    comics, series, events, orderBy, limit, offset)
            else ->
                characterRepository.characters(name, nameStartsWith, modifiedSince, comics, series,
                events, stories, orderBy, limit, offset)
        }
}