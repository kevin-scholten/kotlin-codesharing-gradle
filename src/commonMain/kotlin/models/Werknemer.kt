package models

import kotlinx.serialization.Serializable

@Serializable
data class Werknemer(
    val id: Long?,
    val name: String?,
    val age: Int?,
    val emails: List<String>,
    val company: String?,
    var telefoonnummer: String?
    )
val legeWerknemer = Werknemer(null, null, null, listOf(), null, null)