import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.response.*

fun main() {
    val werknemer = Werknemer(1, "John Doe", 21, listOf("john-doe@gmail.com", "john-doe@softwarecompanyltd.com"), "Software Company Ltd.")
    embeddedServer(Netty, port = 3000, host = "127.0.0.1") {
        routing {
            get("/api/werknemer") {
                call.respond(HttpStatusCode.OK, Gson().toJson(werknemer).toString())
            }
        }
    }.start(wait = true)
}