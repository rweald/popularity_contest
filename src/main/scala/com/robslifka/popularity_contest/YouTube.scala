package com.robslifka.popularity_contest

import net.liftweb.json._

case class StatisticsExtractor (viewCount:String, likeCount:String, dislikeCount:String, favoriteCount:String, commentCount:String)

class YouTubeVideo private (id:String, stats:StatisticsExtractor) {
  val viewCount:Long = stats.viewCount.toLong
  val likeCount:Long = stats.likeCount.toLong
  val dislikeCount:Long = stats.dislikeCount.toLong
  val favoriteCount:Long = stats.favoriteCount.toLong
  val commentCount:Long = stats.commentCount.toLong
}

object YouTubeVideo {

  def apply(id:String, api_key:String) = {
    implicit val formats = DefaultFormats
    val videoUrl = "https://www.googleapis.com/youtube/v3/videos?part=statistics&id=" + id + "&key=" + apiKey
    val json = parse(scala.io.Source.fromURL(videoUrl).getLines().mkString("\n"))
    new YouTubeVideo(id, (json \\ "statistics").extract[StatisticsExtractor])  
  }
  
}
