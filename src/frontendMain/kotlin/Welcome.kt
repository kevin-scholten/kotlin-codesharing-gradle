import api.getWerknemerFromBackend
import api.setTelefoonnummer
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.clear
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import models.Werknemer
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*
import react.redux.useDispatch
import react.redux.useSelector
import redux.RAction
import state.AppState
import styled.styledButton
import styled.styledInput
import validators.isTelefoonnummerValid

fun RBuilder.welcome() = child(functionComponent {
    val dispatch = useDispatch<RAction, AppState>()
    val werknemer = useSelector<AppState, Werknemer?> { it.werknemer.werknemer }
    var tempTelefoonnummer = ""
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
    p {
        b { +"Telefoonnummer: " }
    }
    if(!werknemer?.telefoonnummer.isNullOrBlank()) {
        p { +werknemer?.telefoonnummer!! }
    }
    styledInput {
        attrs {
            type = InputType.text
            id = "inputTelefoon"
            defaultValue = werknemer?.telefoonnummer.orEmpty()
            onChangeFunction = {event->
                tempTelefoonnummer = (event.target as HTMLInputElement).value
            }
        }
    }
    styledButton {
        attrs.onClickFunction = {
            if(isTelefoonnummerValid(tempTelefoonnummer)) {
                setTelefoonnummer(dispatch, tempTelefoonnummer)
                (document.getElementById("inputTelefoon") as HTMLInputElement).value = ""
            } else {
                window.alert("Telefoonnummer niet valide!")
            }
        }
        +"Zet telefoonnummer"
    }
})