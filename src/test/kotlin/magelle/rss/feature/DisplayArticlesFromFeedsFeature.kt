package magelle.rss.feature

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.junit.Test

class DisplayArticlesFromFeedsFeature {

    @get:Rule
    val wireMockRule = WireMockRule(8089)

    @Test
    fun `should display articles from a feed`() {
        stubFor(get(urlEqualTo("/feed"))
                .willReturn(aResponse()
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

        /*val feed = FeedCatalog().get("http://localhost:8089/feed")
        val entries = feed.entries

        assertThat(entries).isNotEmpty
        assertThat(entries[0].title).isEqualTo("RSS Tutorial")
        assertThat(entries[0].description).isEqualTo("RSS Tutorial")

        assertThat(entries[1].title).isEqualTo("XML Tutorial")
        assertThat(entries[1].description).isEqualTo("New XML tutorial on W3Schools")*/
    }
}

