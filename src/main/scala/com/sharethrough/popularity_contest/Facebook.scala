package com.sharethrough.popularity_contest

import net.liftweb.json._
import java.net.URLEncoder

case class Facebook private (id:String, shares:Long, comments:Long)

object Facebook {

  def apply(url:String) = {
    implicit val formats = DefaultFormats

    val facebookEndpoint = "http://graph.facebook.com/?id=" + URLEncoder.encode(url, "UTF-8")
    val json = parse(scala.io.Source.fromURL(facebookEndpoint).getLines().mkString("\n"))
    json.extract[Facebook]
  }

}
