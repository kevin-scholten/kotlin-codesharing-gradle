package utils

import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.fetch.RequestCredentials
import org.w3c.fetch.RequestInit
import kotlin.js.json

val BASE_URL = "/api"

val WerknemerSysteemBackend = { url: String, method: String? ->
    window.fetch(BASE_URL +url, object: RequestInit {
        override var method: String? = method.toString()
        override var credentials: RequestCredentials? = "same-origin".asDynamic()
        override var headers: dynamic = json("Accept" to "application/json")
    })
        .then { it.text() }
}

val WerknemerSysteemBackendPost = { url: String, method: String?, body: String? ->
    window.fetch(BASE_URL +url, object: RequestInit {
        override var method: String? = method.toString()
        override var body: dynamic = body
        override var credentials: RequestCredentials? = "same-origin".asDynamic()
        override var headers: dynamic = json("Accept" to "application/json")
    })
        .then { it.text() }
}