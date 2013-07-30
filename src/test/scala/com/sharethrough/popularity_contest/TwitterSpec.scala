package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification

class TwitterSpec extends Specification {

  ".apply" should {

    "fetch and parse JSON from the Twitter endpoint" in {
      val url = "http://www.buzzfeed.com/despicableme2/15-reasons-we-wish-we-were-steve-carell/"

      val result = BetamaxHelper.withTape[Twitter]("Twitter.apply", {
        Twitter(url)
      })

      result.url    must_== url
      result.tweets must_== 29
    }
  }
}
