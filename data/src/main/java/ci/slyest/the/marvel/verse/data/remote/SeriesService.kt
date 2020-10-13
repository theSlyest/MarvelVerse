package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeriesService {

    @GET("series")
    fun series(
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("title") title: String?,
        @Query("titleStartsWith") titleStartsWith: String?,
        @Query("startYear") startYear: Int?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("seriesType") seriesType: String?,
        @Query("contains") contains: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<SeriesDataWrapper>

    @GET("comics/{comicId}/series")
    fun comicSeries(
        @Path("comicId") comicId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("title") title: String?,
        @Query("titleStartsWith") titleStartsWith: String?,
        @Query("startYear") startYear: Int?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("stories") stories: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("seriesType") seriesType: String?,
        @Query("contains") contains: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<SeriesDataWrapper>

    @GET("events/{eventId}/series")
    fun eventSeries(
        @Path("eventId") eventId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("title") title: String?,
        @Query("titleStartsWith") titleStartsWith: String?,
        @Query("startYear") startYear: Int?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("seriesType") seriesType: String?,
        @Query("contains") contains: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<SeriesDataWrapper>

    @GET("characters/{characterId}/series")
    fun characterSeries(
        @Path("characterId") characterId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("title") title: String?,
        @Query("titleStartsWith") titleStartsWith: String?,
        @Query("startYear") startYear: Int?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("seriesType") seriesType: String?,
        @Query("contains") contains: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<SeriesDataWrapper>

    @GET("creators/{creatorId}/series")
    fun creatorSeries(
        @Path("creatorId") creatorId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("title") title: String?,
        @Query("titleStartsWith") titleStartsWith: String?,
        @Query("startYear") startYear: Int?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("stories") stories: String?,
        @Query("events") events: String?,
        @Query("characters") characters: String?,
        @Query("seriesType") seriesType: String?,
        @Query("contains") contains: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<SeriesDataWrapper>

    @GET("stories/{storyId}/series")
    fun storySeries(
        @Path("storyId") storyId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("title") title: String?,
        @Query("titleStartsWith") titleStartsWith: String?,
        @Query("startYear") startYear: Int?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("events") events: String?,
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("seriesType") seriesType: String?,
        @Query("contains") contains: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<SeriesDataWrapper>
}