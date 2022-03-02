import kotlinx.browser.window
import org.w3c.fetch.RequestCredentials
import org.w3c.fetch.RequestInit
import kotlin.js.json

val BASE_URL = "/api"

val ScreenitBackend = { url: String, method: String? ->
    window.fetch(BASE_URL+url, object: RequestInit {
        override var method: String? = method.toString()
        override var credentials: RequestCredentials? = "same-origin".asDynamic()
        override var headers: dynamic = json("Accept" to "application/json")
    })
        .then { it.text() }
}