package nl.kvns.backend

import Werknemer
import com.google.gson.Gson
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class MyController {
    @GetMapping("/werknemer")
    fun getWerknemer(): String {
        return Gson().toJson(Werknemer(1, "John Doe", 32, listOf("john.doe@gmail.com", "john.doe@softwarecompanybv.com"), "Software Company BV"))
    }
}