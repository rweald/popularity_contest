package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification

class FacebookSpec extends Specification {

  val facebook = new Facebook

  "Facebook#fetch" should {

    "fetch and parse JSON from the FB endpoint" in {
      val url = "http://www.google.com"

      val result = BetamaxHelper.withTape[FacebookResult]("Facebook.apply", {
        facebook.fetch(url)
      })

      result.id       must_== url
      result.shares   must_== 6620203
      result.comments must_== 2
    }

    "provide comments:0 when there are no comments in the resultings JSON" in {
      val url = "http://www.allaboutbalance.com"

      val result = BetamaxHelper.withTape[FacebookResult]("Facebook.noComments", {
        facebook.fetch(url)
      })

      result.comments must_== 0
    }
  }

  "Facebook.apply" should {
    "create a facebook instance and then fetch the url" in {
      val url = "http://www.google.com"

      val result = BetamaxHelper.withTape[FacebookResult]("Facebook.apply", {
        Facebook(url)
      })

      result.id       must_== url
      result.shares   must_== 6620203
      result.comments must_== 2
    }
  }
}
