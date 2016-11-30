# RSS Feeds

RSS Feed aggregator

## Goal

Practice technologies

## Steps

* Analyze RSS business
* Find domains
* Init project

## Technologies

Back:
* Spring
* CQRS (Axon)
* Maven
* Kotlin

Front:
* React
* Redux
* TypeScript
* Webpack

## Methodologies

* TDD
* ATDD
* DDD
* DataDD

## Domain vocabulary

* Feed, a Stream of dated information (ex RSS, Atom)
  - Entry, a dated information (a post, a news, an entry)

* Subscription
  - article

## Functionalities

* FeedStream
  - handle RSS, Atom
  - handle twitter
  - handle website
  - get latest entries

* Article
  - Read/Unread
  - Favorites
  - Rate
  - Reading time estimation
  - Tags
  - Reading Video and GIF
  - Share email, facebook, ...
  - Estimate article interest
  - Search in article

* Subscription
  - Add/remove
  - classify by folder / category
  - Tags
  - Mark all as read
  - unread count
  - search in subscriptions
  - search new subscription
  - suggest new subscription
  - synchronize
  - Subscription composition - smart selection

## MVP 1

* Display one RSS feed
  - query Feed
  - rest Kotlin
    - ws static
    - ws returned feed's entries
  - react redux
    - display static
    - display feed's entries
