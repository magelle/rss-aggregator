package magelle.rss.infra.synchronization

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.sun.syndication.feed.synd.SyndEntry
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class FeedCatalogTest {

    @get:Rule
    val wireMockRule = WireMockRule(8089)

    @Test
    fun `a RSS 2 feed`() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/feed"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("""
<?xml version="1.0" encoding="UTF-8" ?>
<rss version="2.0">
    <channel>
        <title>W3Schools Home Page</title>
        <link>http://www.w3schools.com</link>
        <description>Free web building tutorials</description>
        <item>
            <title>RSS Tutorial</title>
            <link>http://www.w3schools.com/xml/xml_rss.asp</link>
            <description>New RSS tutorial on W3Schools</description>
        </item>
        <item>
            <title>XML Tutorial</title>
            <link>http://www.w3schools.com/xml</link>
            <description>New XML tutorial on W3Schools</description>
        </item>
    </channel>
</rss>
""")))

        val feedCatalog = FeedCatalog()
        val syndFeed = feedCatalog.get("http://localhost:8089/feed")

        assertThat(syndFeed.entries).isNotEmpty

        SyndEntryVerifier(syndFeed.entries[0] as SyndEntry)
                .assertTitleIsEqualTo("RSS Tutorial")
                .assertDescriptionIsEqualTo("New RSS tutorial on W3Schools")

        SyndEntryVerifier(syndFeed.entries[1] as SyndEntry)
                .assertTitleIsEqualTo("XML Tutorial")
                .assertDescriptionIsEqualTo("New XML tutorial on W3Schools")
    }

    class SyndEntryVerifier(val entry: SyndEntry) {
        fun assertTitleIsEqualTo(expected: String): SyndEntryVerifier {
            assertThat(entry.title).isEqualTo(expected)
            return this
        }

        fun assertDescriptionIsEqualTo(expected: String): SyndEntryVerifier {
            assertThat(entry.description.value).isEqualTo(expected)
            return this
        }
    }

}