package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CreatorService {

    @GET("creators")
    fun creators(
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("firstName") firstName: String?,
        @Query("middleName") middleName: String?,
        @Query("lastName") lastName: String?,
        @Query("firstNameStartsWith") firstNameStartsWith: String?,
        @Query("middleNameStartsWith") middleNameStartsWith: String?,
        @Query("lastNameStartsWith") lastNameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CreatorDataWrapper>

    @GET("comics/{comicId}/creators")
    fun comicCreators(
        @Path("comicId") comicId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("firstName") firstName: String?,
        @Query("middleName") middleName: String?,
        @Query("lastName") lastName: String?,
        @Query("firstNameStartsWith") firstNameStartsWith: String?,
        @Query("middleNameStartsWith") middleNameStartsWith: String?,
        @Query("lastNameStartsWith") lastNameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CreatorDataWrapper>

    @GET("events/{eventId}/creators")
    fun eventCreators(
        @Path("eventId") eventId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("firstName") firstName: String?,
        @Query("middleName") middleName: String?,
        @Query("lastName") lastName: String?,
        @Query("firstNameStartsWith") firstNameStartsWith: String?,
        @Query("middleNameStartsWith") middleNameStartsWith: String?,
        @Query("lastNameStartsWith") lastNameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CreatorDataWrapper>

    @GET("series/{seriesId}/creators")
    fun seriesCreators(
        @Path("seriesId") seriesId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("firstName") firstName: String?,
        @Query("middleName") middleName: String?,
        @Query("lastName") lastName: String?,
        @Query("firstNameStartsWith") firstNameStartsWith: String?,
        @Query("middleNameStartsWith") middleNameStartsWith: String?,
        @Query("lastNameStartsWith") lastNameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CreatorDataWrapper>

    @GET("stories/{storyId}/creators")
    fun storyCreators(
        @Path("storyId") storyId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("firstName") firstName: String?,
        @Query("middleName") middleName: String?,
        @Query("lastName") lastName: String?,
        @Query("firstNameStartsWith") firstNameStartsWith: String?,
        @Query("middleNameStartsWith") middleNameStartsWith: String?,
        @Query("lastNameStartsWith") lastNameStartsWith: String?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("comics") comics: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<CreatorDataWrapper>
}