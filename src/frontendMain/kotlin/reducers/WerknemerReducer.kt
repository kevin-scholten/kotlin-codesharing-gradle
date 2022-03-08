package reducers

import actions.SetWerknemerAction
import models.legeWerknemer
import state.WerknemerState

fun werknemerReducer(stateSlice: WerknemerState = WerknemerState(legeWerknemer), action: Any): WerknemerState = when (action) {
    is SetWerknemerAction -> WerknemerState(action.werknemer)
    else -> stateSlice
}