package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

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