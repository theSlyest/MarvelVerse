package ci.slyest.the.marvel.verse.domain.repositories

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import io.reactivex.rxjava3.core.Single
import java.util.*

interface CharacterRepository {

    fun characters(characterRequest: CharacterRequest): Single<CharacterDataWrapper>

//    fun characterById(id: Int): Single<CharacterDataWrapper>
}