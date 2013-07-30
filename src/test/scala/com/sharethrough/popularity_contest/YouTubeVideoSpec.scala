package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification

class YouTubeVideoSpec extends Specification {

  "YoutubeVideo#fetch" should {
    val youtube = new YouTubeVideo

    "fetch and parse JSON from the YT endpoint" in {
      val videoId = "5hWIr9_noRo"

      val result = BetamaxHelper.withTape[YouTubeVideoResult]("YouTubeVideo.apply", {
        youtube.fetch(videoId)
      })

      result.id        must_== videoId
      result.views     must_== 517851
      result.rating    must    beCloseTo(4.77f, 0.1f)
      result.ratings   must_== 457
      result.likes     must_== 431
      result.favorites must_== 0
      result.comments  must_== 295
    }
  }

  "YoutubeVideo.apply" should {
    "create an instance of YoutubeVideo and fetch the specificed id" in {
      val videoId = "5hWIr9_noRo"

      val result = BetamaxHelper.withTape[YouTubeVideoResult]("YouTubeVideo.apply", {
        YouTubeVideo(videoId)
      })

      result.id        must_== videoId
      result.views     must_== 517851
      result.rating    must    beCloseTo(4.77f, 0.1f)
      result.ratings   must_== 457
      result.likes     must_== 431
      result.favorites must_== 0
      result.comments  must_== 295
    }
  }
}
