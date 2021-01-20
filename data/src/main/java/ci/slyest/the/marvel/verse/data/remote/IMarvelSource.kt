package ci.slyest.the.marvel.verse.data.remote

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

abstract class IMarvelSource {

    protected fun getTimestamp(): String = Timestamp(System.currentTimeMillis()).time.toString()

    protected fun getHash(ts: String): String {
        val str = ts + PRIVATE_KEY + PUBLIC_KEY
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(str.toByteArray())).toString(16)
    }

    protected fun formatDate(modifiedSince: Date?) =
        modifiedSince?.run {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this)
        }
}