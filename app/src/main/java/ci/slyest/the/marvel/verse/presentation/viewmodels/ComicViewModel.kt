package ci.slyest.the.marvel.verse.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import ci.slyest.the.marvel.verse.domain.entities.ComicDataWrapper
import ci.slyest.the.marvel.verse.domain.usecases.ComicsUseCase
import ci.slyest.the.marvel.verse.presentation.models.Response
import ci.slyest.the.marvel.verse.presentation.models.Status
import ci.slyest.the.marvel.verse.presentation.repositories.comicPagedList
import ci.slyest.the.marvel.verse.presentation.repositories.pagingConfig
import ci.slyest.the.marvel.verse.presentation.sources.ComicDataSourceFactory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*

class ComicViewModel(private val useCase: ComicsUseCase): ViewModel() {

    private var mutableState: MutableLiveData<Response> = MutableLiveData()
    val state: LiveData<Response>
        get() {
            return mutableState
        }

    private lateinit var disposable: Disposable

    private var mFormat: String? = null
    private var mFormatType: String? = null
    private var mNoVariants: Boolean? = null
    private var mDateDescriptor: String? = null
    private var mDateRange: String? = null
    private var mTitle: String? = null
    private var mTitleStartsWith: String? = null
    private var mStartYear: Int? = null
    private var mIssueNumber: Int? = null
    private var mDiamondCode: String? = null
    private var mDigitalId: Int? = null
    private var mUpc: String? = null
    private var mIsbn: String? = null
    private var mEan: String? = null
    private var mIssn: String? = null
    private var mHasDigitalIssue: Boolean? = null
    private var mModifiedSince: Date? = null
    private var mCreators: String? = null
    private var mCharacters: String? = null
    private var mSeries: String? = null
    private var mEvents: String? = null
    private var mStories: String? = null
    private var mSharedAppearances: String? = null
    private var mCollaborators: String? = null
    private var mOrderBy: String? = null

    init {
        if (comicPagedList == null)
            comicPagedList =
                LivePagedListBuilder(ComicDataSourceFactory(this), pagingConfig).build()
    }

    fun setQueryParams(
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: String? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: String? = null,
        characters: String? = null,
        series: String? = null,
        events: String? = null,
        stories: String? = null,
        sharedAppearances: String? = null,
        collaborators: String? = null,
        orderBy: String? = null
    ) {
        mFormat = format
        mFormatType = formatType
        mNoVariants = noVariants
        mDateDescriptor = dateDescriptor
        mDateRange = dateRange
        mTitle = title
        mTitleStartsWith = titleStartsWith
        mStartYear = startYear
        mIssueNumber = issueNumber
        mDiamondCode = diamondCode
        mDigitalId = digitalId
        mUpc = upc
        mIsbn = isbn
        mEan = ean
        mIssn = issn
        mHasDigitalIssue = hasDigitalIssue
        mModifiedSince = modifiedSince
        mCreators = creators
        mCharacters = characters
        mSeries = series
        mEvents = events
        mStories = stories
        mSharedAppearances = sharedAppearances
        mCollaborators = collaborators
        mOrderBy = orderBy
    }

    fun comics(limit: Int? = null, offset: Int? = null) : Single<ComicDataWrapper> {
        mutableState.postValue(Response(status = Status.LOADING))
        useCase(mFormat, mFormatType, mNoVariants, mDateDescriptor, mDateRange, mTitle,
            mTitleStartsWith, mStartYear, mIssueNumber, mDiamondCode, mDigitalId, mUpc, mIsbn, mEan,
            mIssn, mHasDigitalIssue, mModifiedSince, mCreators, mCharacters, mSeries, mEvents,
            mStories, mSharedAppearances, mCollaborators, mOrderBy, limit, offset).let { single ->
            disposable = single.subscribe({
                mutableState.postValue(Response(status = Status.SUCCESSFUL))
                disposable.dispose()
            }, { error ->
                mutableState.postValue(Response(status = Status.ERROR, error = error))
                disposable.dispose()
            })
            return single
        }
    }
}