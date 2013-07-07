package com.sharethrough.popularity_contest

import co.freeside.betamax.Recorder
import co.freeside.betamax.proxy.jetty.ProxyServer

class FacebookSpec extends SequentialSpecification {

  ".apply" should {
    "fetch and parse JSON from the FB endpoint" in {
      val recorder = new Recorder
      val proxyServer = new ProxyServer(recorder)

      recorder.insertTape("Facebook.apply")
      proxyServer.start()

      val fbState = Facebook("http://www.google.com")

      recorder.ejectTape()
      proxyServer.stop()

      fbState.id       must_== "http://www.google.com"
      fbState.shares   must_== 6620203
      fbState.comments must_== 2
    }

    "provide comments:0 when there are no comments in the resultings JSON" in {
      val recorder = new Recorder
      val proxyServer = new ProxyServer(recorder)

      recorder.insertTape("Facebook.noComments")
      proxyServer.start()

      try {
        val fbState = Facebook("http://www.allaboutbalance.com")
        fbState.comments must_== 0
      } finally {
        recorder.ejectTape()
        proxyServer.stop()
      }
    }
  }
}
