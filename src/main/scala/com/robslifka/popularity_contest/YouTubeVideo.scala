package com.robslifka.popularity_contest

import net.liftweb.json._

case class YouTubeVideo private (id:String, viewCount:Long, rating:Float,
  ratingCount:Long, likeCount:String, favoriteCount:Long, commentCount:Long) {
  
  def views     : Long = viewCount.toLong
  def ratings   : Long = ratingCount.toLong
  def likes     : Long = likeCount.toLong
  def favorites : Long = favoriteCount.toLong
  def comments  : Long = commentCount.toLong
}

object YouTubeVideo {

  def apply(id:String) = {
    implicit val formats = DefaultFormats
    val ytEndpoint = "http://gdata.youtube.com/feeds/api/videos/"+id+"?v=2&alt=jsonc"
    val json = parse(scala.io.Source.fromURL(ytEndpoint).getLines().mkString("\n"))
    (json \\ "data").extract[YouTubeVideo]
  }

}
