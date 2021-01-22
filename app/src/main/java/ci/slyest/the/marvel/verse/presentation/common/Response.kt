package ci.slyest.the.marvel.verse.presentation.common

/** A generic wrapper class around data request. */
data class Response(var status: Status, var error: Throwable? = null)

/** Possible statuses of a request. */
enum class Status { SUCCESSFUL, ERROR, LOADING }
