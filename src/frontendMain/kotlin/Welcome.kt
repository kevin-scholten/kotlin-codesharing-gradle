import api.getWerknemerFromBackend
import kotlinx.serialization.Serializable
import react.*
import react.dom.ReactHTML.h1
import react.dom.ReactHTML.p
import react.redux.useDispatch
import react.redux.useSelector
import redux.RAction
import state.AppState

fun RBuilder.welcome() = child(functionComponent {
    val dispatch = useDispatch<RAction, AppState>()
    val werknemer = useSelector<AppState, Werknemer?> { it.werknemer.werknemer }

    useEffectOnce {
        getWerknemerFromBackend(dispatch)
    }
    h1 { +"Werknemer informatie" }
    p {+"Volledige naam: ${werknemer?.name}"}
    p {+"Leeftijd: ${werknemer?.age}"}
    p {+"Bedrijf: ${werknemer?.company}"}
})