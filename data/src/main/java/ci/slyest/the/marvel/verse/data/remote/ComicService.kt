package ci.slyest.the.marvel.verse.data.remote

import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit 2 interface for comics queries
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
 */
interface ComicService {

    /**
     * Fetches lists of comics with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param format [String] Filter by the issue format (e.g. comic, digital comic, hardcover).
     * @param formatType [String] Filter by the issue format type (comic or collection).
     * @param noVariants [Boolean] Exclude variants (alternate covers, secondary printings, director's cuts, etc.) from the result set.
     * @param dateDescriptor [String] Return comics within a predefined date range.
     * @param dateRange [String] Return comics within a predefined date range. Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02). Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format.
     * @param title [String] Return only issues in series whose title matches the input.
     * @param titleStartsWith [String] Return only issues in series whose title starts with the input.
     * @param startYear [Int] Return only issues in series whose start year matches the input.
     * @param issueNumber [Int] Return only issues in series whose issue number matches the input.
     * @param diamondCode [String] Filter by diamond code.
     * @param digitalId [Int] Filter by digital comic id.
     * @param upc [String] Filter by UPC.
     * @param isbn [String] Filter by ISBN.
     * @param ean [String] Filter by EAN.
     * @param issn [String] Filter by ISSN.
     * @param hasDigitalIssue [Boolean] Include only results which are available digitally.
     * @param modifiedSince [String] Return only comics which have been modified since the specified date.
     * @param creators [String] Return only comics which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only comics which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param sharedAppearances [String] Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids.
     * @param collaborators [String] Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
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

    /**
     * Fetches lists of comics containing a specific character, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param format [String] Filter by the issue format (e.g. comic, digital comic, hardcover).
     * @param formatType [String] Filter by the issue format type (comic or collection).
     * @param noVariants [Boolean] Exclude variants (alternate covers, secondary printings, director's cuts, etc.) from the result set.
     * @param dateDescriptor [String] Return comics within a predefined date range.
     * @param dateRange [String] Return comics within a predefined date range. Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02). Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format.
     * @param title [String] Return only issues in series whose title matches the input.
     * @param titleStartsWith [String] Return only issues in series whose title starts with the input.
     * @param startYear [Int] Return only issues in series whose start year matches the input.
     * @param issueNumber [Int] Return only issues in series whose issue number matches the input.
     * @param diamondCode [String] Filter by diamond code.
     * @param digitalId [Int] Filter by digital comic id.
     * @param upc [String] Filter by UPC.
     * @param isbn [String] Filter by ISBN.
     * @param ean [String] Filter by EAN.
     * @param issn [String] Filter by ISSN.
     * @param hasDigitalIssue [Boolean] Include only results which are available digitally.
     * @param modifiedSince [String] Return only comics which have been modified since the specified date.
     * @param creators [String] Return only comics which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param sharedAppearances [String] Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids.
     * @param collaborators [String] Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("characters/{characterId}/comics")
    fun characterComics(
        @Path("characterId") characterId: Int,
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
        @Query("series") series: String?,
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("sharedAppearances") sharedAppearances: String?,
        @Query("collaborators") collaborators: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<ComicDataWrapper>

    /**
     * Fetches lists of comics in which the work of a specific creator appears, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param format [String] Filter by the issue format (e.g. comic, digital comic, hardcover).
     * @param formatType [String] Filter by the issue format type (comic or collection).
     * @param noVariants [Boolean] Exclude variants (alternate covers, secondary printings, director's cuts, etc.) from the result set.
     * @param dateDescriptor [String] Return comics within a predefined date range.
     * @param dateRange [String] Return comics within a predefined date range. Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02). Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format.
     * @param title [String] Return only issues in series whose title matches the input.
     * @param titleStartsWith [String] Return only issues in series whose title starts with the input.
     * @param startYear [Int] Return only issues in series whose start year matches the input.
     * @param issueNumber [Int] Return only issues in series whose issue number matches the input.
     * @param diamondCode [String] Filter by diamond code.
     * @param digitalId [Int] Filter by digital comic id.
     * @param upc [String] Filter by UPC.
     * @param isbn [String] Filter by ISBN.
     * @param ean [String] Filter by EAN.
     * @param issn [String] Filter by ISSN.
     * @param hasDigitalIssue [Boolean] Include only results which are available digitally.
     * @param modifiedSince [String] Return only comics which have been modified since the specified date.
     * @param characters [String] Return only comics which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param sharedAppearances [String] Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids.
     * @param collaborators [String] Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("creators/{creatorId}/comics")
    fun creatorComics(
        @Path("creatorId") creatorId: Int,
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

    /**
     * Fetches lists of comics which take place during a specific event, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param format [String] Filter by the issue format (e.g. comic, digital comic, hardcover).
     * @param formatType [String] Filter by the issue format type (comic or collection).
     * @param noVariants [Boolean] Exclude variants (alternate covers, secondary printings, director's cuts, etc.) from the result set.
     * @param dateDescriptor [String] Return comics within a predefined date range.
     * @param dateRange [String] Return comics within a predefined date range. Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02). Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format.
     * @param title [String] Return only issues in series whose title matches the input.
     * @param titleStartsWith [String] Return only issues in series whose title starts with the input.
     * @param startYear [Int] Return only issues in series whose start year matches the input.
     * @param issueNumber [Int] Return only issues in series whose issue number matches the input.
     * @param diamondCode [String] Filter by diamond code.
     * @param digitalId [Int] Filter by digital comic id.
     * @param upc [String] Filter by UPC.
     * @param isbn [String] Filter by ISBN.
     * @param ean [String] Filter by EAN.
     * @param issn [String] Filter by ISSN.
     * @param hasDigitalIssue [Boolean] Include only results which are available digitally.
     * @param modifiedSince [String] Return only comics which have been modified since the specified date.
     * @param creators [String] Return only comics which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only comics which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param sharedAppearances [String] Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids.
     * @param collaborators [String] Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("events/{eventId}/comics")
    fun eventComics(
        @Path("eventId") eventId: Int,
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
        @Query("stories") stories: String?,
        @Query("sharedAppearances") sharedAppearances: String?,
        @Query("collaborators") collaborators: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<ComicDataWrapper>

    /**
     * Fetches lists of comics which are published as part of a specific series, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param format [String] Filter by the issue format (e.g. comic, digital comic, hardcover).
     * @param formatType [String] Filter by the issue format type (comic or collection).
     * @param noVariants [Boolean] Exclude variants (alternate covers, secondary printings, director's cuts, etc.) from the result set.
     * @param dateDescriptor [String] Return comics within a predefined date range.
     * @param dateRange [String] Return comics within a predefined date range. Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02). Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format.
     * @param title [String] Return only issues in series whose title matches the input.
     * @param titleStartsWith [String] Return only issues in series whose title starts with the input.
     * @param startYear [Int] Return only issues in series whose start year matches the input.
     * @param issueNumber [Int] Return only issues in series whose issue number matches the input.
     * @param diamondCode [String] Filter by diamond code.
     * @param digitalId [Int] Filter by digital comic id.
     * @param upc [String] Filter by UPC.
     * @param isbn [String] Filter by ISBN.
     * @param ean [String] Filter by EAN.
     * @param issn [String] Filter by ISSN.
     * @param hasDigitalIssue [Boolean] Include only results which are available digitally.
     * @param modifiedSince [String] Return only comics which have been modified since the specified date.
     * @param creators [String] Return only comics which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only comics which feature the specified characters (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param stories [String] Return only characters which appear the specified stories (accepts a comma-separated list of ids).
     * @param sharedAppearances [String] Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids.
     * @param collaborators [String] Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("series/{seriesId}/comics")
    fun seriesComics(
        @Path("seriesId") seriesId: Int,
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
        @Query("events") events: String?,
        @Query("stories") stories: String?,
        @Query("sharedAppearances") sharedAppearances: String?,
        @Query("collaborators") collaborators: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<ComicDataWrapper>

    /**
     * Fetches lists of comics in which a specific story appears, with optional filters.
     * @see <a href="https://developer.marvel.com/docs">developer.marvel.com/docs</a>
     * @param apiKey [String] Marvel API key
     * @param hash [String] Digest
     * @param format [String] Filter by the issue format (e.g. comic, digital comic, hardcover).
     * @param formatType [String] Filter by the issue format type (comic or collection).
     * @param noVariants [Boolean] Exclude variants (alternate covers, secondary printings, director's cuts, etc.) from the result set.
     * @param dateDescriptor [String] Return comics within a predefined date range.
     * @param dateRange [String] Return comics within a predefined date range. Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02). Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format.
     * @param title [String] Return only issues in series whose title matches the input.
     * @param titleStartsWith [String] Return only issues in series whose title starts with the input.
     * @param startYear [Int] Return only issues in series whose start year matches the input.
     * @param issueNumber [Int] Return only issues in series whose issue number matches the input.
     * @param diamondCode [String] Filter by diamond code.
     * @param digitalId [Int] Filter by digital comic id.
     * @param upc [String] Filter by UPC.
     * @param isbn [String] Filter by ISBN.
     * @param ean [String] Filter by EAN.
     * @param issn [String] Filter by ISSN.
     * @param hasDigitalIssue [Boolean] Include only results which are available digitally.
     * @param modifiedSince [String] Return only comics which have been modified since the specified date.
     * @param creators [String] Return only comics which feature work by the specified creators (accepts a comma-separated list of ids).
     * @param characters [String] Return only comics which feature the specified characters (accepts a comma-separated list of ids).
     * @param series [String] Return only characters which appear the specified series (accepts a comma-separated list of ids).
     * @param events [String] Return only characters which appear in the specified events (accepts a comma-separated list of ids).
     * @param sharedAppearances [String] Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids.
     * @param collaborators [String] Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids.
     * @param orderBy [String] Order the result set by a field or fields. Add a "-" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.
     * @param limit [Int] Limit the result set to the specified number of resources.
     * @param offset [Int] Skip the specified number of resources in the result set.
     */
    @GET("stories/{storyId}/comics")
    fun storyComics(
        @Path("storyId") storyId: Int,
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
        @Query("sharedAppearances") sharedAppearances: String?,
        @Query("collaborators") collaborators: String?,
        @Query("orderBy") orderBy: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Single<ComicDataWrapper>
}