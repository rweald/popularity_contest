package com.sharethrough.popularity_contest

import net.liftweb.json._
import java.net.URLEncoder

case class TwitterResult private (url:String, count:Long) {
  val tweets = count
}

class Twitter {
  def fetch(url: String): TwitterResult = {
    implicit val formats = DefaultFormats
    val twitterEndpoint = "http://urls.api.twitter.com/1/urls/count.json?url=" + URLEncoder.encode(url, "UTF-8")
    val json = parse(scala.io.Source.fromURL(twitterEndpoint).getLines().mkString("\n"))
    json.extract[TwitterResult]
  }
}

object Twitter {

  def apply(url:String) = {
    (new Twitter).fetch(url)
  }

}
