package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification

class FacebookSpec extends Specification {

  ".apply" should {

    "fetch and parse JSON from the FB endpoint" in {
      val url = "http://www.google.com"

      var fb:Facebook = null
      BetamaxHelper.withTape("Facebook.apply", () => {
        fb = Facebook(url)
      })

      fb.id       must_== url
      fb.shares   must_== 6620203
      fb.comments must_== 2
    }

    "provide comments:0 when there are no comments in the resultings JSON" in {
      val url = "http://www.allaboutbalance.com"

      var fb:Facebook = null
      BetamaxHelper.withTape("Facebook.noComments", () => {
        fb = Facebook(url)
      })

      fb.comments must_== 0
    }
  }
}
