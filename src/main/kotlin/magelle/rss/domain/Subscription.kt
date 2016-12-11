package magelle.rss.domain

class Subscription(val url: String) {
    var articles: List<Article> = emptyList()
}

