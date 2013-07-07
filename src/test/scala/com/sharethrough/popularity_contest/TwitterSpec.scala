package com.sharethrough.popularity_contest

class TwitterSpec extends SequentialSpecification {

  ".apply" should {

    "fetch and parse JSON from the Twitter endpoint" in {
      val url = "http://www.buzzfeed.com/despicableme2/15-reasons-we-wish-we-were-steve-carell/"

      var tw:Twitter = null
      BetamaxHelper.withTape("Twitter.apply", () => {
        tw = Twitter(url)
      })

      tw.url    must_== url
      tw.tweets must_== 29
    }
  }
}
