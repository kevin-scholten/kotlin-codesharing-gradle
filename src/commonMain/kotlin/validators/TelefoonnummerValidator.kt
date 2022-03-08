package validators

fun isTelefoonnummerValid(telefoonnummer: String): Boolean {
	return telefoonnummerCheck(telefoonnummer)
}

fun telefoonnummerCheck(telefoonnummer: String): Boolean {
	return isVastNlNummer(telefoonnummer) ||
			isMobielNlNummer(telefoonnummer) ||
			isInformatieNlNummer(telefoonnummer) ||
			isBuitenlandsNummer(telefoonnummer)
}

fun isVastNlNummer(telefoonnummer: String): Boolean {
	return telefoonnummer.matches(Regex("^(0[0-9]{9})|(0[0-9]{2}( |-)[0-9]{7})|(0[0-9]{3}( |-)[0-9]{6})\$"))
}

fun isMobielNlNummer(telefoonnummer: String): Boolean {
	return telefoonnummer.matches(Regex("^(06( |-)?[0-9]{8})\$"))
}

fun isInformatieNlNummer(telefoonnummer: String): Boolean {
	return telefoonnummer.matches(Regex("^(0(8|9)00( |-)?\\d{4}(\\d{3})?\$)\$"))
}

fun isBuitenlandsNummer(telefoonnummer: String): Boolean {
	return telefoonnummer.matches(Regex("^(\\+|00)[0-9 -]{4,15}\$"))
}