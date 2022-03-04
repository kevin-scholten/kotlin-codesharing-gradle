package api

import utils.ScreenitBackend
import Werknemer
import actions.SetWerknemerAction
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import state.AppState

fun getWerknemerFromBackend(dispatch: (SetWerknemerAction) -> AppState) {
    ScreenitBackend("/werknemer", "GET").then { result ->
        dispatch(SetWerknemerAction(JSON.parse(result)))
    }
}