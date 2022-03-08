package nl.kvns.backend

import com.google.gson.Gson
import models.Werknemer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import validators.isTelefoonnummerValid

@RestController
@RequestMapping("api/werknemer")
class MyController {
    val werknemer = Werknemer(1, "John Doe", 32, listOf("john.doe@gmail.com", "john.doe@softwarecompanybv.com"), "Software Company BV", "")

    @GetMapping
    fun getWerknemer(): String {
        return Gson().toJson(werknemer)
    }

    @PutMapping("/telefoonnummer")
    fun setTelefoonnummer(@RequestBody telefoonnummer: String): ResponseEntity<Any?> {
        if(isTelefoonnummerValid(telefoonnummer)) {
            werknemer.telefoonnummer = telefoonnummer
            return ResponseEntity<Any?>(werknemer, HttpStatus.OK)
        } else {
            return ResponseEntity<Any?>("Phone number not valid.", HttpStatus.BAD_REQUEST)
        }
    }
}