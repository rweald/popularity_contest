[![Build Status](https://secure.travis-ci.org/rslifka/popularity_contest.png)](http://travis-ci.org/rslifka/popularity_contest)

## It's A Popularity Contest! └[∵┌]└[ ∵ ]┘[┐∵]┘

"Popularity Contest" is a tiny Scala project we created while building our multifactored Content Quality Scoring algorithm, primarily to experiment with integration testing of API (specifically JSON) endpoints.  We wrote about it on the [Sharethrough Engineering blog](http://www.sharethrough.com/2013/07/integration-testing-http-requests-with-scala-and-betamax/).

Use PC to find out social activity data around YouTube videos and URLs shared on Facebook and Twitter.

## Installation ヾ(⌐■_■)ノ♪

Hosted on Sonatype, via SBT:

    "com.sharethrough" %% "popularity_contest" % "0.9"
        
## Usage (~^.^)~

    import com.sharethrough.popularity_contest._

    object PopularityExercise extends App {

      val fb = Facebook("http://www.google.com")
      println("Graphing: %s, Shares: %d, Comments: %d".format(fb.id, fb.shares, fb.comments))

      val tw = Twitter("http://www.sharethrough.com/")
      println("Tweeting: %s, Tweets: %d".format(tw.url, tw.tweets))

      val yt = YouTubeVideo("LXxjEYIANS4")
      println("Viewing: %s, Views: %d, Rating: %f, Ratings: %d, Likes: %d, Favorites: %d, Comments: %d".format(yt.id, yt.views, yt.rating, yt.ratings, yt.likes, yt.favorites, yt.comments))
      
    }

## Contributing ＼(＾O＾)／

Follow along with priorities (and drop some of your own!) on [Trello](https://trello.com/board/popularity-contest/51d0fb957e25710b780025ff).

This project comes with an SBT wrapper script that will automatically download the correct version of SBT and Scala. All you have to do is running the following command from the root of the project

```
./sbt
```

This will fire up the SBT repl where you can begin issuing commands. For example to run the tests you would simply type ```test``` into the SBT repl.  If you don't want to use the repl you can also run the test suite from your normal command prompt using the following command:

```
./sbt test
```

## License (°ロ°)☝

    Copyright 2013 Robert Slifka, Ryan Weald

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
