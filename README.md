# Kotlin JS/JVM Code delen Gradle multiplatform (English below)
### Deze applicatie bevat:
* React Kotlin/JS Front-end module (gebruikt IR compiler)
* SpringBoot Kotlin/JVM Back-end module
* Gedeelde Kotlin common bron module<br />
  * `Werknemer`<br />
  * `TelefoonnummerValidator` Telefoonnummer validatielogica

Het project is gemaakt met de IntelliJ KotlinJS Multiplatform initializer. De applicatie laat de gegevens van de `Werknemer` zien. De informatie wordt opgehaald van de back-end via een API-call. De `Werknemer` data klasse is gedeeld tussen de front-end en back-end modules. Deze bevinden zich in de `commonMain` module. De gebruiker kan het telefoonnummer van de werknemer invoeren via het Nederlandse of internationale telefoonnummerformat. Telefoonnummer validatielogica is ook gedeeld tussen front- en back-end en wordt gecheckt op beide modules.

### De applicaties starten
1. Start SpringBoot via de 'main' functie.
2. Voer 'gradle frontendBrowserDevelopmentRun' uit om de front-end op te starten.
3. Ga naar `localhost:8080` voor de front-end, `localhost:3000/api/werknemer` voor de back-end calls.

**_NOTE:_**  De back-end call is geproxied van poort 3000 om CORS policy errors te voorkomen.


--------------------------

# Kotlin JS/JVM Codesharing Gradle multiplatform
### This application contains:
* React Kotlin/JS Front-end module (uses IR compiler)
* SpringBoot Kotlin/JVM Back-end module
* Shared Kotlin common source module<br />
  * `Werknemer` (employee)<br />
  * `TelefoonnummerValidator` Phone number validation logic.

The project is made with the IntelliJ KotlinJS Multiplatform initializer. The template already present shows Werknemer (Employee) information at the front-end. This info is received from the back-end by an API call. The `Werknemer` data class is shared between front-end and back-end modules. This can be found in the `commonMain` module. The user can set the phone number of the employee only in the correct dutch/international phone number format. Phone number validation logic is also shared between back-end and front-end and checked on both modules.

### Starting the applications
1. Start SpringBoot via the main function.
2. Run 'gradle frontendBrowserDevelopmentRun' to start the front-end.
3. go to `localhost:8080` for front-end, `localhost:3000/api/werknemer` for back-end calls.

**_NOTE:_**  The back-end call is proxied from port 3000 to avoid CORS policy errors.



*Created by Kevin Scholten on March 2nd 2022 as Proof of Concept.*
