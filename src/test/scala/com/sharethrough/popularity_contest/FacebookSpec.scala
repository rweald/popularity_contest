package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification

class FacebookSpec extends Specification {

  ".apply" should {

    "fetch and parse JSON from the FB endpoint" in {
      val url = "http://www.google.com"

      val result = BetamaxHelper.withTape[Facebook]("Facebook.apply", {
        Facebook(url)
      })

      result.id       must_== url
      result.shares   must_== 6620203
      result.comments must_== 2
    }

    "provide comments:0 when there are no comments in the resultings JSON" in {
      val url = "http://www.allaboutbalance.com"

      val result = BetamaxHelper.withTape[Facebook]("Facebook.noComments", {
        Facebook(url)
      })

      result.comments must_== 0
    }
  }
}
