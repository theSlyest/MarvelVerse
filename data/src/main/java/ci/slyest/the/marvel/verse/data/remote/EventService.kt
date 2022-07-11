package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit 2 interface for event queries
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
interface EventService {

    /**
     * Fetches lists of events with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only events which match the specified name.
     * @param nameStartsWith [String] Return events with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only events which have been modified since the specified date.
     * @param creators [String] Return only events which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only events which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only events which are part of the specified series (accepts a comma-separated list of ids).
     * @param comics [String] Return only events which take place in the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only events which take place in the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("events")
    fun events(
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("series") series: String?,
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<EventDataWrapper>

    /**
     * Fetches lists of events in which a specific comic appears, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only events which match the specified name.
     * @param nameStartsWith [String] Return events with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only events which have been modified since the specified date.
     * @param creators [String] Return only events which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only events which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only events which are part of the specified series (accepts a comma-separated list of ids).
     * @param stories [String] Return only events which take place in the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("comics/{comicId}/events")
    fun comicEvents(
        @Path("comicId") comicId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("series") series: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<EventDataWrapper>

    /**
     * Fetches lists of events in which a specific character appears, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only events which match the specified name.
     * @param nameStartsWith [String] Return events with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only events which have been modified since the specified date.
     * @param creators [String] Return only events which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param series [String] Return only events which are part of the specified series (accepts a comma-separated list of ids).
     * @param comics [String] Return only events which take place in the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only events which take place in the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("characters/{characterId}/events")
    fun characterEvents(
        @Path("characterId") characterId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("creators") creators: String?,
        @Query("series") series: String?,
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<EventDataWrapper>

    /**
     * Fetches lists of events featuring the work of a specific creator, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only events which match the specified name.
     * @param nameStartsWith [String] Return events with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only events which have been modified since the specified date.
     * @param characters [String] Return only events which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only events which are part of the specified series (accepts a comma-separated list of ids).
     * @param comics [String] Return only events which take place in the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only events which take place in the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("characters/{creatorId}/events")
    fun creatorEvents(
        @Path("creatorId") creatorId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("characters") characters: String?,
        @Query("series") series: String?,
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<EventDataWrapper>

    /**
     * Fetches lists of events which occur in a specific series, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only events which match the specified name.
     * @param nameStartsWith [String] Return events with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only events which have been modified since the specified date.
     * @param creators [String] Return only events which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only events which feature the specified characters (accepts a comma-separated list of ids).
     * @param comics [String] Return only events which take place in the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only events which take place in the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("series/{seriesId}/events")
    fun seriesEvents(
        @Path("seriesId") seriesId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<EventDataWrapper>

    /**
     * Fetches lists of events in which a specific story appears, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only events which match the specified name.
     * @param nameStartsWith [String] Return events with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only events which have been modified since the specified date.
     * @param creators [String] Return only events which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only events which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only events which are part of the specified series (accepts a comma-separated list of ids).
     * @param comics [String] Return only events which take place in the specified comics (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("stories/{storyId}/events")
    fun storyEvents(
        @Path("storyId") storyId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("series") series: String?,
        @Query("comics") comics: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<EventDataWrapper>
}