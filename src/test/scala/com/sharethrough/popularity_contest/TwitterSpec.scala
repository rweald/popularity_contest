package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification

class TwitterSpec extends Specification {

  "Twitter#fetch" should {
    val twitter = new Twitter

    "fetch and parse JSON from the Twitter endpoint" in {
      val url = "http://www.buzzfeed.com/despicableme2/15-reasons-we-wish-we-were-steve-carell/"

      val result = BetamaxHelper.withTape[TwitterResult]("Twitter.apply", {
        twitter.fetch(url)
      })

      result.url    must_== url
      result.tweets must_== 29
    }
  }

  "Twitter.apply" should {

    "create an instance of Twitter and fetch the supplied url" in {
      val url = "http://www.buzzfeed.com/despicableme2/15-reasons-we-wish-we-were-steve-carell/"

      val result = BetamaxHelper.withTape[TwitterResult]("Twitter.apply", {
        Twitter(url)
      })

      result.url    must_== url
      result.tweets must_== 29
    }
  }
}
