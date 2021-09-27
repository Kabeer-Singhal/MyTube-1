package com.example.mytube.models

import androidx.lifecycle.LiveData
import com.squareup.moshi.Json

data class VideosList(
    val kind: String,
    @Json(name = "etag")val eTag: String,
    val items:MutableList<AboutVideo>,
    var nextPageToken: String = "",
    val pageInfo: PageInformation
)

data class AboutVideo(
    val kind: String,
    @Json(name = "etag")val eTag: String,
    val id: String,
    val snippet: VideoSnippet,
    var statistics: VideoStats = VideoStats(0)
)

data class PageInformation(
    val totalResults: Int,
    val resultsPerPage: Int
)

data class VideoSnippet(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val thumbnails: ThumbnailSizes,
    val channelTitle: String,
)

data class ThumbnailSizes(
    @Json(name="default")var defaultThumb: ThumbnailFeatures? = null,
    var medium: ThumbnailFeatures? = null,
    var high: ThumbnailFeatures? = null,
    var standard: ThumbnailFeatures? = null,
    var maxres: ThumbnailFeatures? = null
)

data class ThumbnailFeatures(
    val url: String,
    val width: Int,
    val height: Int
)

data class VideoStats(
    var viewCount: Int,
    var likeCount: Int = 0,
    var dislikeCount: Int = 0,
    var favoriteCount: Int = 0,
    var commentCount: Int = 0
)

data class ChannelSnippet(
    val title: String,
    var customUrl: String = "",
    val publishedAt: String,
    val thumbnails: ThumbnailSizes
)

data class ChannelDetails(
    val items: List<Channels>
)

data class Channels(
    var id: String = "",
    val snippet: ChannelSnippet
)