package com.robslifka.popularity_contest

import net.liftweb.json._
import java.net.URLEncoder

case class Twitter private (url:String, count:Long) {
  val tweets = count
}

object Twitter {

  def apply(url:String) = {
    implicit val formats = DefaultFormats
    val twitterEndpoint = "http://urls.api.twitter.com/1/urls/count.json?url=" + URLEncoder.encode(url, "UTF-8")
    val json = parse(scala.io.Source.fromURL(twitterEndpoint).getLines().mkString("\n"))
    json.extract[Twitter]
  }

}
