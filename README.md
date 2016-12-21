# RSS Feeds

[![Build Status][travis-image]][travis-url]
[![codecov](https://codecov.io/gh/magelle/rss-aggregator/branch/master/graph/badge.svg)](https://codecov.io/gh/magelle/rss-aggregator)

RSS Feed aggregator

## Goal

Practice technologies

## Steps

* Analyze RSS business
* Find domains
* Init project

## Technologies

Build:
* Gradle

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

Tools :
* JUnit 4.12
* AssertJ
* Mockito
* Wiremock: http://wiremock.org/
* Rome

## Methodologies

* TDD
* ATDD
* DDD
* DataDD

## Domain vocabulary

* Feed, a Stream of dated information (ex RSS, Atom)
  - Entry, a dated information (a post, a news, an entry)
* Subscription
  - Article

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

## To Do
* Implementation living documentation
* Use ROME
* Use API REST and how to Test

[travis-image]: https://travis-ci.org/magelle/rss-aggregator.svg?branch=master
[travis-url]: https://travis-ci.org/magelle/rss-aggregator.svg