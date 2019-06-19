package rm.kubeboot

import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@RunWith(SpringRunner::class)
@SpringBootTest
class IntegrationTest {
    val origin = "http://localhost:9090"
    val webClient = WebClient.create()

    @Before
    fun setUp() {
        SpringApplication.start(9090)
    }

    @After
    fun tearDown() {
        SpringApplication.stop()
    }

    @Test
    fun `root path responds with Hello, I am Kubeboot`() {
        val url = "$origin/"

        val body = get(url)

        assertThat(body, equalTo("Hello, I am Kubeboot"))
    }

    private fun get(url: String): String {
        return webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError) { response: ClientResponse -> Mono.error(Exception("Request 'GET " + url + "' gave response with status code " + response.statusCode().value())) }
                .bodyToMono<String>()
                .block()
                .orEmpty()
    }
}
