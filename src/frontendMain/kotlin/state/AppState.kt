package state

import models.legeWerknemer

class AppState(val werknemer: WerknemerState = WerknemerState(legeWerknemer)) {
    companion object {
        val INITIAL_STATE = AppState()
    }
}
