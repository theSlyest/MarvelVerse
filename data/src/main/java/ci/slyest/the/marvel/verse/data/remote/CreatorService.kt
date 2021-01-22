package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.CreatorDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit 2 interface for creator queries
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
interface CreatorService {

    /**
     * Fetches lists of comic creators with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param firstName [String] Filter by creator first name (e.g. Brian).
     * @param middleName [String] Filter by creator middle name (e.g. Michael).
     * @param lastName [String] Filter by creator last name (e.g. Bendis).
     * @param firstNameStartsWith [String] Filter by creator first names that match criteria (e.g. B, St L).
     * @param middleNameStartsWith [String] Filter by creator middle names that match criteria (e.g. Mi).
     * @param lastNameStartsWith [String] Filter by creator last names that match criteria (e.g. Ben).
     * @param modifiedSince [String] Return only creators which have been modified since the specified date.
     * @param comics [String] Return only creators who worked on in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only creators who worked on in the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only creators who worked on comics that took place in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only creators who worked on the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic creators whose work appears in a specific comic, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param firstName [String] Filter by creator first name (e.g. Brian).
     * @param middleName [String] Filter by creator middle name (e.g. Michael).
     * @param lastName [String] Filter by creator last name (e.g. Bendis).
     * @param firstNameStartsWith [String] Filter by creator first names that match criteria (e.g. B, St L).
     * @param middleNameStartsWith [String] Filter by creator middle names that match criteria (e.g. Mi).
     * @param lastNameStartsWith [String] Filter by creator last names that match criteria (e.g. Ben).
     * @param modifiedSince [String] Return only creators which have been modified since the specified date.
     * @param series [String] Return only creators who worked on in the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only creators who worked on comics that took place in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only creators who worked on the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic creators whose work appears in a specific event, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param firstName [String] Filter by creator first name (e.g. Brian).
     * @param middleName [String] Filter by creator middle name (e.g. Michael).
     * @param lastName [String] Filter by creator last name (e.g. Bendis).
     * @param firstNameStartsWith [String] Filter by creator first names that match criteria (e.g. B, St L).
     * @param middleNameStartsWith [String] Filter by creator middle names that match criteria (e.g. Mi).
     * @param lastNameStartsWith [String] Filter by creator last names that match criteria (e.g. Ben).
     * @param modifiedSince [String] Return only creators which have been modified since the specified date.
     * @param comics [String] Return only creators who worked on in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only creators who worked on in the specified series (accepts a comma-separated list of ids).
     * @param stories [String] Return only creators who worked on the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic creators whose work appears in a specific series, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param firstName [String] Filter by creator first name (e.g. Brian).
     * @param middleName [String] Filter by creator middle name (e.g. Michael).
     * @param lastName [String] Filter by creator last name (e.g. Bendis).
     * @param firstNameStartsWith [String] Filter by creator first names that match criteria (e.g. B, St L).
     * @param middleNameStartsWith [String] Filter by creator middle names that match criteria (e.g. Mi).
     * @param lastNameStartsWith [String] Filter by creator last names that match criteria (e.g. Ben).
     * @param modifiedSince [String] Return only creators which have been modified since the specified date.
     * @param comics [String] Return only creators who worked on in the specified comics (accepts a comma-separated list of ids).
     * @param events [String] Return only creators who worked on comics that took place in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only creators who worked on the specified stories (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comic creators whose work appears in a specific story, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param firstName [String] Filter by creator first name (e.g. Brian).
     * @param middleName [String] Filter by creator middle name (e.g. Michael).
     * @param lastName [String] Filter by creator last name (e.g. Bendis).
     * @param firstNameStartsWith [String] Filter by creator first names that match criteria (e.g. B, St L).
     * @param middleNameStartsWith [String] Filter by creator middle names that match criteria (e.g. Mi).
     * @param lastNameStartsWith [String] Filter by creator last names that match criteria (e.g. Ben).
     * @param modifiedSince [String] Return only creators which have been modified since the specified date.
     * @param comics [String] Return only creators who worked on in the specified comics (accepts a comma-separated list of ids).
     * @param series [String] Return only creators who worked on in the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only creators who worked on comics that took place in the specified events (accepts a comma-separated list of ids).
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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