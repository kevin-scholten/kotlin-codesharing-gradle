import api.getWerknemerFromBackend
import react.*
import react.dom.b
import react.dom.h1
import react.dom.p
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

    h1 { +"Werknemer info" }
    p {
        b { +"Volledige naam: " }
        +"${werknemer?.name}"
    }
    p {
        b { +"Leeftijd: " }
        +"${werknemer?.age}"
    }
    p {
        b { +"Emails: " }
    }
    werknemer?.emails?.forEachIndexed { index, email ->
        p {+"   ${index + 1}. $email"}
    }
    p {
        b { +"Bedrijf: " }
        +"${werknemer?.company}"
    }

})