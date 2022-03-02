import api.getWerknemerFromBackend
import kotlinx.serialization.Serializable
import react.*
import react.dom.ReactHTML.h1
import react.redux.useDispatch
import react.redux.useSelector
import redux.RAction
import state.AppState

fun RBuilder.welcome() = child(functionComponent {
    val dispatch = useDispatch<RAction, AppState>()

    useEffectOnce {
        getWerknemerFromBackend(dispatch)
    }
    val werknemer = useSelector<AppState, Werknemer?> { it.werknemer.werknemer }

    h1 {
        +"Hello, ${werknemer?.name}"
    }
})