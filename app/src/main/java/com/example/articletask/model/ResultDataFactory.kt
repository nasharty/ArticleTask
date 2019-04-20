package com.example.articletask.model

import java.util.ArrayList

object ResultDataFactory {

    fun createDummyResults(): List<Result> {
        val results = ArrayList<Result>()
        val result = Result()
        result.title = "Test Title"
        result.byline = "Test Byline"
        result.publishedDate = "24-4-2019"
        val media = ArrayList<Medium>()
        val mediaMetadata = ArrayList<MediaMetadatum>()
        val medium = Medium()
        val mediaMetadatum = MediaMetadatum()
        mediaMetadatum.url =
                "https://static01.nyt.com/images/2019/04/14/us/2020-candidates-tax-returns-promo-1555242819752/2020-candidates-tax-returns-promo-1555242819752-square320-v4.png"
        mediaMetadata.add(mediaMetadatum)
        medium.mediaMetadata = mediaMetadata
        medium.mediaMetadata = mediaMetadata
        media.add(medium)
        result.media = media
        return results
    }
}
