package com.sharethrough.popularity_contest

import org.specs2.mutable.Specification
import co.freeside.betamax.Recorder
import co.freeside.betamax.proxy.jetty.ProxyServer

class FacebookSpec extends Specification {

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
  }
}
