package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification

class YouTubeVideoSpec extends Specification {

  ".apply" should {
    "fetch and parse JSON from the YT endpoint" in {
      val videoId = "5hWIr9_noRo"

      var yt:YouTubeVideo = null
      BetamaxHelper.withTape("YouTubeVideo.apply", () => {
        yt = YouTubeVideo(videoId)
      })

      yt.id        must_== videoId
      yt.views     must_== 517851
      yt.rating    must    beCloseTo(4.77f, 0.1f)
      yt.ratings   must_== 457
      yt.likes     must_== 431
      yt.favorites must_== 0
      yt.comments  must_== 295
    }
  }
}
