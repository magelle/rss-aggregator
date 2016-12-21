package magelle.rss.infra.synchronization

import com.sun.syndication.feed.synd.SyndFeed
import com.sun.syndication.io.SyndFeedInput
import com.sun.syndication.io.XmlReader
import java.net.URL

class FeedCatalog {
    fun get(url: String): SyndFeed {
        val feedUrl = URL(url)
        val xmlReader = XmlReader(feedUrl)
        return SyndFeedInput().build(xmlReader)
    }
}