package ci.slyest.the.marvel.verse.data.remote

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/** Abstract source class */
abstract class IMarvelSource {

    /**
     * Get the current timestamp as a [String].
     * @return a [String] containing the current timestamp.
     */
    protected fun getTimestamp(): String = Timestamp(System.currentTimeMillis()).time.toString()

    /**
     * Compute the next request hash: md5(timeStamp + privateKey + publicKey)
     * @param timeStamp [String] containing a timestamp.
     * @return [String] containing the hash for the next request.
     */
    protected fun getHash(timeStamp: String): String {
        val str = timeStamp + PRIVATE_KEY + PUBLIC_KEY
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(str.toByteArray())).toString(16)
    }

    /**
     * Convert a date to the format used by the requests.
     * @param date [Date] object.
     * @return a [String] containing the given date in a specific format, or NULL if the date is NULL.
     */
    protected fun formatDate(date: Date?) =
        date?.run {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this)
        }
}