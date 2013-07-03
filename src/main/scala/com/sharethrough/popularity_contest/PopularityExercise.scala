package com.sharethrough.popularity_contest

/*
  This lives in the README.md as the complete example of the API.
 */
object PopularityExercise extends App {

    val fb = Facebook("http://www.google.com")
    println("Graphing: %s, Shares: %d, Comments: %d".format(fb.id, fb.shares, fb.comments))

    val tw = Twitter("http://www.sharethrough.com/")
    println("Tweeting: %s, Tweets: %d".format(tw.url, tw.tweets))

    val yt = YouTubeVideo("LXxjEYIANS4")
    println("Viewing: %s, Views: %d, Rating: %f, Ratings: %d, Likes: %d, Favorites: %d, Comments: %d".format(
      yt.id, yt.views, yt.rating, yt.ratings, yt.likes, yt.favorites, yt.comments))
}
