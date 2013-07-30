package com.sharethrough.popularity_contest

import net.liftweb.json._
import java.net.URLEncoder

case class FacebookResult private (id:String, shares:Long, comments:Long) {
  def this(id:String, shares:Long) = this(id, shares, 0)
}

class Facebook {
  def fetch(url: String): FacebookResult = {
    implicit val formats = DefaultFormats

    val facebookEndpoint = "http://graph.facebook.com/?id=" + URLEncoder.encode(url, "UTF-8")
    val json = parse(scala.io.Source.fromURL(facebookEndpoint).getLines().mkString("\n"))
    json.extract[FacebookResult]
  }
}

object Facebook {

  def apply(url:String): FacebookResult = {
    (new Facebook).fetch(url)
  }

}
