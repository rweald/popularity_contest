package com.sharethrough.popularity_contest

import co.freeside.betamax.Recorder
import co.freeside.betamax.proxy.jetty.ProxyServer

object BetamaxHelper {

  /**
   * Execute the provided function wrapped in a proxy server injecting the
   * specified tape.
   *
   * @param tapeName Name of the tape to insert
   * @param functionUnderTest Function to execute
   */
  def withTape(tapeName:String, functionUnderTest:() => Any) = {

    val recorder = new Recorder
    val proxyServer = new ProxyServer(recorder)

    recorder.insertTape(tapeName)
    proxyServer.start()

    try {
      functionUnderTest()
    } finally {
      recorder.ejectTape()
      proxyServer.stop()
    }

  }

}
