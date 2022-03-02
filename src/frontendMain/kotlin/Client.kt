import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.redux.provider
import reducers.rootReducer
import redux.RAction
import redux.createStore
import redux.rEnhancer
import state.AppState

fun main() {
    val store = createStore<AppState, RAction, dynamic>(
        ::rootReducer, AppState(), rEnhancer()
    )
    window.onload = {
        render(document.getElementById("root")) {
            provider(store) {
                welcome()
            }
        }
    }
}
