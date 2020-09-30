package ci.slyest.the.marvel.verse.data.remote

import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterSourceTest {

    private val marvelSource = CharacterSource(MarvelModule.service())

    @Test
    fun charactersSuccess() {
        var code = 0
        var status = ""
        marvelSource.characters()
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

    @Test
    fun characterByIdSuccess() {
        var code = 0
        var status = ""
        marvelSource.characterById(1011334)
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