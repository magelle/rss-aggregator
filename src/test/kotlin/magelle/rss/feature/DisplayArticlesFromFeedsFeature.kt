package magelle.rss.feature

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.assertj.core.api.Assertions
import org.junit.Rule
import org.junit.Test
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.MediaType

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

        val client = ClientBuilder.newClient()
        val response = client.target("http://localhost:8080/entries")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(String::class.java)

        Assertions.assertThat(response).isEqualTo("""[{ "title": "RSS Tutorial", "content":"New RSS tutorial on W3Schools" },{ "title": "XML Tutorial", "content":"New XML tutorial on W3Schools" }]""")
    }
}

