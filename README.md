# Kotlin JS/JVM Code sharing Gradle multiplatform

## This application contains:
- React Kotlin/JS Front-end module
- SpringBoot Kotlin/JVM Back-end module
- Shared Kotlin common source module
|- `Werknemer` (employee)
|- Phone number validation logic.

The template already present shows Werknemer (Employee) information at the front-end. This info is received from the back-end by an API call. The `Werknemer` data class is shared between front-end and back-end modules. This can be found in the `commonMain` module. The user can set the phone number of the employee only in the correct dutch phone number format. Phone number validation logic is also shared between back-end and front-end and checked on both modules.

## Starting the applications
1. Start SpringBoot via the main function.
2. Run 'gradle frontendBrowserDevelopmentRun' to start the front-end.
3. go to `localhost:8080` for front-end, `localhost:3000/api/werknemer` for back-end calls.

**_NOTE:_**  The back-end call is proxied from port 3000.



*Created by Kevin Scholten on March 2nd 2022 as Proof of Concept.*
