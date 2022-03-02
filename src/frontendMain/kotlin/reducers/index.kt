package reducers

import redux.RAction
import state.AppState

fun rootReducer(appState: AppState, action: RAction) = AppState(
    werknemer = werknemerReducer(appState.werknemer, action)
)