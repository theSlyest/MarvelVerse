package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import io.reactivex.rxjava3.core.Single
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class CharacterSource(private val characterService: CharacterService) {

    private fun getTimestamp(): String = Timestamp(System.currentTimeMillis()).time.toString()

    private fun getHash(ts: String): String {
        val str = ts + PRIVATE_KEY + PUBLIC_KEY
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(str.toByteArray())).toString(16)
    }

    fun characters(
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
    ): Single<CharacterDataWrapper> {
        val ts = getTimestamp()
        val hash = getHash(ts)
        val since: String? = modifiedSince?.run {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this)
        }
        return characterService.characters(
            PUBLIC_KEY, ts, hash, name, nameStartsWith, since,
            comics, series, events, stories, orderBy, limit, offset)
    }

    fun characterById(id: Int): Single<CharacterDataWrapper> {
        val ts = getTimestamp()
        val hash = getHash(ts)
        return characterService.characterById(id, PUBLIC_KEY, ts, hash)
    }
}