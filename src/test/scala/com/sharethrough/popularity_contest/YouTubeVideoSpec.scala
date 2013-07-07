package com.sharethrough.popularity_contest

import co.freeside.betamax.Recorder
import co.freeside.betamax.proxy.jetty.ProxyServer

class YouTubeVideoSpec extends SequentialSpecification {

  ".apply" should {
    "fetch and parse JSON from the YT endpoint" in {
      val recorder = new Recorder
      val proxyServer = new ProxyServer(recorder)

      recorder.insertTape("YouTubeVideo.apply")
      proxyServer.start()

      val ytStats = YouTubeVideo("5hWIr9_noRo")

      recorder.ejectTape()
      proxyServer.stop()

      ytStats.id        must_== "5hWIr9_noRo"
      ytStats.views     must_== 517851
      ytStats.rating    must beCloseTo(4.77f, 0.1f)
      ytStats.ratings   must_== 457
      ytStats.likes     must_== 431
      ytStats.favorites must_== 0
      ytStats.comments  must_== 295
    }
  }
}
