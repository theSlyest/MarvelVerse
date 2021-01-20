package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.EventDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventService {

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