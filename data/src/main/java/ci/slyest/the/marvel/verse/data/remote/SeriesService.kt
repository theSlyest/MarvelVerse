package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.SeriesDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit 2 interface for series queries
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
interface SeriesService {

    /**
     * Fetches lists of comic series with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param title [String] Return only series matching the specified title.
     * @param titleStartsWith [String] Return series with titles that begin with the specified string (e.g. Sp).
     * @param startYear [Int] Return only series matching the specified start year.
     * @param modifiedSince [String] Return only series which have been modified since the specified date.
     * @param comics [String] Return only series which contain the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only series which contain the specified stories (accepts a comma-separated list of ids).
     * @param events [String] Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids).
     * @param creators [String] Return only series which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only series which feature the specified characters (accepts a comma-separated list of ids).
     * @param seriesType [String] Filter the series by publication frequency type.
     * @param contains [String] Return only series containing one or more comics with the specified format.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic series in which a specific event takes place, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param title [String] Return only series matching the specified title.
     * @param titleStartsWith [String] Return series with titles that begin with the specified string (e.g. Sp).
     * @param startYear [Int] Return only series matching the specified start year.
     * @param modifiedSince [String] Return only series which have been modified since the specified date.
     * @param comics [String] Return only series which contain the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only series which contain the specified stories (accepts a comma-separated list of ids).
     * @param creators [String] Return only series which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only series which feature the specified characters (accepts a comma-separated list of ids).
     * @param seriesType [String] Filter the series by publication frequency type.
     * @param contains [String] Return only series containing one or more comics with the specified format.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic series in which a specific character appears, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param title [String] Return only series matching the specified title.
     * @param titleStartsWith [String] Return series with titles that begin with the specified string (e.g. Sp).
     * @param startYear [Int] Return only series matching the specified start year.
     * @param modifiedSince [String] Return only series which have been modified since the specified date.
     * @param comics [String] Return only series which contain the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only series which contain the specified stories (accepts a comma-separated list of ids).
     * @param events [String] Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids).
     * @param creators [String] Return only series which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param seriesType [String] Filter the series by publication frequency type.
     * @param contains [String] Return only series containing one or more comics with the specified format.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic series in which a specific creator's work appears, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param title [String] Return only series matching the specified title.
     * @param titleStartsWith [String] Return series with titles that begin with the specified string (e.g. Sp).
     * @param startYear [Int] Return only series matching the specified start year.
     * @param modifiedSince [String] Return only series which have been modified since the specified date.
     * @param comics [String] Return only series which contain the specified comics (accepts a comma-separated list of ids).
     * @param stories [String] Return only series which contain the specified stories (accepts a comma-separated list of ids).
     * @param events [String] Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids).
     * @param characters [String] Return only series which feature the specified characters (accepts a comma-separated list of ids).
     * @param seriesType [String] Filter the series by publication frequency type.
     * @param contains [String] Return only series containing one or more comics with the specified format.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic series in which the specified story takes place, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param title [String] Return only series matching the specified title.
     * @param titleStartsWith [String] Return series with titles that begin with the specified string (e.g. Sp).
     * @param startYear [Int] Return only series matching the specified start year.
     * @param modifiedSince [String] Return only series which have been modified since the specified date.
     * @param comics [String] Return only series which contain the specified comics (accepts a comma-separated list of ids).
     * @param events [String] Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids).
     * @param creators [String] Return only series which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only series which feature the specified characters (accepts a comma-separated list of ids).
     * @param seriesType [String] Filter the series by publication frequency type.
     * @param contains [String] Return only series containing one or more comics with the specified format.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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