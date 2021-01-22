package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterRequest
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterSourceTest {

    private val marvelSource = CharacterSource(MarvelModule.characterService())

    @Test
    fun charactersSuccess() {
        var code = 0
        var status = ""
        val request = CharacterRequest(limit = 32, offset = 16)
        marvelSource.characters(request)
            .blockingSubscribe({ wrapper ->
                code = wrapper.code
                status = wrapper.status
                wrapper.data.results
            }, { error ->
                status = error.message!!
            })
        assertEquals(code, 200)
        assertEquals(status, "Ok")
    }
}