package com.sharethrough.popularity_contest

import net.liftweb.json._

case class YouTubeVideoResult private (id:String, viewCount:Long, rating:Float,
  ratingCount:Long, likeCount:String, favoriteCount:Long, commentCount:Long) {

  def views     : Long = viewCount.toLong
  def ratings   : Long = ratingCount.toLong
  def likes     : Long = likeCount.toLong
  def favorites : Long = favoriteCount.toLong
  def comments  : Long = commentCount.toLong
}

class YouTubeVideo {
  def fetch(id: String): YouTubeVideoResult = {
    implicit val formats = DefaultFormats
    val ytEndpoint = "http://gdata.youtube.com/feeds/api/videos/"+id+"?v=2&alt=jsonc"
    val json = parse(scala.io.Source.fromURL(ytEndpoint).getLines().mkString("\n"))
    (json \\ "data").extract[YouTubeVideoResult]
  }
}

object YouTubeVideo {

  def apply(id:String) = {
    (new YouTubeVideo).fetch(id)
  }

}
