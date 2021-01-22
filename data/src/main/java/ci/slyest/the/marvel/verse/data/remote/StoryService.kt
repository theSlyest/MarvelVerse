package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit 2 interface for stories queries
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
interface StoryService {

    /**
     * Fetches lists of comic stories with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param modifiedSince [String] Return only stories which have been modified since the specified date.
     * @param comics [String] Return only stories contained in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only stories contained the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only stories which take place during the specified events (accepts a comma-separated list of ids).
     * @param creators [String] Return only stories which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only stories which feature the specified characters (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("stories")
    fun stories(
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<StoryDataWrapper>

    /**
     * Fetches lists of comic stories featuring a specific character, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param modifiedSince [String] Return only stories which have been modified since the specified date.
     * @param comics [String] Return only stories contained in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only stories contained the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only stories which take place during the specified events (accepts a comma-separated list of ids).
     * @param creators [String] Return only stories which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("characters/{characterId}/stories")
    fun characterStories(
        @Path("characterId") characterId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<StoryDataWrapper>

    /**
     * Fetches lists of comic stories in a specific comic issue, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param modifiedSince [String] Return only stories which have been modified since the specified date.
     * @param series [String] Return only stories contained the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only stories which take place during the specified events (accepts a comma-separated list of ids).
     * @param creators [String] Return only stories which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only stories which feature the specified characters (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("comics/{comicId}/stories")
    fun comicStories(
        @Path("comicId") comicId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<StoryDataWrapper>

    /**
     * Fetches lists of comic stories from a specific event, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param modifiedSince [String] Return only stories which have been modified since the specified date.
     * @param comics [String] Return only stories contained in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only stories contained the specified series (accepts a comma-separated list of ids).
     * @param creators [String] Return only stories which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only stories which feature the specified characters (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("events/{eventId}/stories")
    fun eventStories(
        @Path("eventId") eventId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<StoryDataWrapper>

    /**
     * Fetches lists of comic stories from a specific series, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param modifiedSince [String] Return only stories which have been modified since the specified date.
     * @param comics [String] Return only stories contained in the specified comics (accepts a comma-separated list of ids).
     * @param events [String] Return only stories which take place during the specified events (accepts a comma-separated list of ids).
     * @param creators [String] Return only stories which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only stories which feature the specified characters (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("series/{seriesId}/stories")
    fun seriesStories(
        @Path("seriesId") seriesId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<StoryDataWrapper>

    /**
     * Fetches lists of comic stories by a specific creator, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param modifiedSince [String] Return only stories which have been modified since the specified date.
     * @param comics [String] Return only stories contained in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only stories contained the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only stories which take place during the specified events (accepts a comma-separated list of ids).
     * @param characters [String] Return only stories which feature the specified characters (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("creators/{creatorId}/stories")
    fun creatorStories(
        @Path("creatorId") creatorId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("characters") characters: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<StoryDataWrapper>
}