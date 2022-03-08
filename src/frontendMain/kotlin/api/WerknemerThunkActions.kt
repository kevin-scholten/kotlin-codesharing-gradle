package api

import utils.ScreenitBackend
import actions.SetWerknemerAction
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import state.AppState
import utils.ScreenitBackendPost

fun getWerknemerFromBackend(dispatch: (SetWerknemerAction) -> AppState) {
    ScreenitBackend("/werknemer", "GET").then { result ->
        dispatch(SetWerknemerAction(Json.decodeFromString(result)))
    }
}

fun setTelefoonnummer(dispatch: (SetWerknemerAction) -> AppState, telefoonNummer: String) {
    ScreenitBackendPost("/werknemer/telefoonnummer", "PUT", telefoonNummer).then { result ->
        dispatch(SetWerknemerAction(Json.decodeFromString(result)))
    }
}