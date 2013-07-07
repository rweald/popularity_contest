package com.sharethrough.popularity_contest

import co.freeside.betamax.Recorder
import co.freeside.betamax.proxy.jetty.ProxyServer

class TwitterSpec extends SequentialSpecification {

  ".apply" should {
    "fetch and parse JSON from the Twitter endpoint" in {
      val recorder = new Recorder
      val proxyServer = new ProxyServer(recorder)

      recorder.insertTape("Twitter.apply")
      proxyServer.start()

      val url = "http://www.buzzfeed.com/despicableme2/15-reasons-we-wish-we-were-steve-carell/"
      val twitterStats = Twitter(url)

      recorder.ejectTape()
      proxyServer.stop()

      twitterStats.url    must_== url
      twitterStats.tweets must_== 29
    }
  }
}
