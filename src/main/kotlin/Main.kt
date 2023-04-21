import kotlin.random.Random

fun main() {
    val optionen = listOf("Schere", "Stein", "Papier") // Liste der möglichen Optionen
    var spielerStand = 0
    var computerStand = 0

    while (spielerStand < 3 && computerStand < 3) {

        println("Spieler: $spielerStand, Computer: $computerStand")
        println("Bitte wähle aus: Schere, Stein oder Papier:")

        val spielerWaehltAus = readlnOrNull()

        if (spielerWaehltAus !in optionen) { // ungültige Eingabe abfangen

            println("Eingabe ungültig: Bitte wählen Sie Schere, Stein oder Papier.")

            continue
        }

        val computerWaehltAus = optionen[Random.nextInt(0, optionen.size)] // Computer wählt zufällig

        println("Computer wählt $computerWaehltAus.")

        // Gewinn möglichkeiten und Count der Punkte des Runden gewinners
        when {
            spielerWaehltAus == computerWaehltAus -> println("Unentschieden, neue Runde!")
            spielerWaehltAus == "Schere" && computerWaehltAus == "Papier" ||
                    spielerWaehltAus == "Stein" && computerWaehltAus == "Schere" ||
                    spielerWaehltAus == "Papier" && computerWaehltAus == "Stein" -> {

                        println("Spieler gewinnt!")

                spielerStand++
            }
            else -> {
                println("Computer gewinnt!")

                computerStand++
            }
        }
    }

    // Siegerehrung
    if (spielerStand > computerStand) {
        println("Herzlichen Glückwunsch, Sie haben gewonnen!")
    } else {
        println("Schade, Sie haben verloren.")
    }
}