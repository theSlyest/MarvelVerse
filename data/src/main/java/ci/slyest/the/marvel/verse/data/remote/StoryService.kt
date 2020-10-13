package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.StoryDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoryService {

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