package api

import utils.WerknemerSysteemBackend
import actions.SetWerknemerAction
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import state.AppState
import utils.WerknemerSysteemBackendPost

fun getWerknemerFromBackend(dispatch: (SetWerknemerAction) -> AppState) {
    WerknemerSysteemBackend("/werknemer", "GET").then { result ->
        dispatch(SetWerknemerAction(Json.decodeFromString(result)))
    }
}

fun setTelefoonnummer(dispatch: (SetWerknemerAction) -> AppState, telefoonNummer: String) {
    WerknemerSysteemBackendPost("/werknemer/telefoonnummer", "PUT", telefoonNummer).then { result ->
        dispatch(SetWerknemerAction(Json.decodeFromString(result)))
    }
}