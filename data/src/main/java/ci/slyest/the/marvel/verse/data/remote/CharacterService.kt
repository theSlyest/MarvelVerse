package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit 2 interface for character queries
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
interface CharacterService {

    /**
     * Fetches lists of characters with optional filters.
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only characters matching the specified full character name (e.g. Spider-Man).
     * @param nameStartsWith [String] Return characters with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only characters which have been modified since the specified date.
     * @param comics [String] Return only characters which appear in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("characters")
    fun characters(
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CharacterDataWrapper>

    /**
     * Fetches lists of characters which appear in a specific comic with optional filters.
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only characters matching the specified full character name (e.g. Spider-Man).
     * @param nameStartsWith [String] Return characters with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only characters which have been modified since the specified date.
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("comics/{comicId}/characters")
    fun comicCharacters(
        @Path("comicId") comicId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CharacterDataWrapper>

    /**
     * Fetches lists of characters which appear in a specific event, with optional filters.
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only characters matching the specified full character name (e.g. Spider-Man).
     * @param nameStartsWith [String] Return characters with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only characters which have been modified since the specified date.
     * @param comics [String] Return only characters which appear in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("events/{eventId}/characters")
    fun eventCharacters(
        @Path("eventId") eventId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CharacterDataWrapper>

    /**
     * Fetches lists of characters which appear in specific series, with optional filters.
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only characters matching the specified full character name (e.g. Spider-Man).
     * @param nameStartsWith [String] Return characters with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only characters which have been modified since the specified date.
     * @param comics [String] Return only characters which appear in the specified comics (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("series/{seriesId}/characters")
    fun seriesCharacters(
        @Path("seriesId") seriesId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CharacterDataWrapper>

    /**
     * Fetches lists of comic characters appearing in a single story, with optional filters.
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param name [String] Return only characters matching the specified full character name (e.g. Spider-Man).
     * @param nameStartsWith [String] Return characters with names that begin with the specified string (e.g. Sp).
     * @param modifiedSince [String] Return only characters which have been modified since the specified date.
     * @param comics [String] Return only characters which appear in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("stories/{storyId}/characters")
    fun storyCharacters(
        @Path("storyId") storyId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String?,
        @Query("nameStartsWith") nameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CharacterDataWrapper>

//    @GET("characters/{id}")
//    fun characterById(
//        @Path("id") id: Int,
//        @Query("apikey") apiKey: String,
//        @Query("ts") ts: String,
//        @Query("hash") hash: String
//    ): Single<CharacterDataWrapper>
}