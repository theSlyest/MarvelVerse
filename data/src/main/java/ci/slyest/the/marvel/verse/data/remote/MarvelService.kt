package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CharacterDataWrapper
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

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

//    @GET("characters/{id}")
//    fun characterById(
//        @Path("id") id: Int,
//        @Query("apikey") apiKey: String,
//        @Query("ts") ts: String,
//        @Query("hash") hash: String
//    ): Single<CharacterDataWrapper>

    @GET("comics")
    fun comics(
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean?, // yyyy-MM-ddThh:mm
        @Query("dateDescriptor") dateDescriptor: String?,
        @Query("dateRange") dateRange: String?,
        @Query("title") title: String?,
        @Query("titleStartsWith") titleStartsWith: String?,
        @Query("startYear") startYear: Int?,
        @Query("issueNumber") issueNumber: Int?,
        @Query("diamondCode") diamondCode: String?,
        @Query("digitalId") digitalId: Int?,
        @Query("upc") upc: String?,
        @Query("isbn") isbn: String?,
        @Query("ean") ean: String?,
        @Query("issn") issn: String?,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean?,
        @Query("modifiedSince") modifiedSince: String?, // yyyy-MM-ddThh:mm
        @Query("creators") creators: String?,
        @Query("characters") characters: String?,
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("sharedAppearances") sharedAppearances: String?,
        @Query("collaborators") collaborators: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<ComicDataWrapper>
}