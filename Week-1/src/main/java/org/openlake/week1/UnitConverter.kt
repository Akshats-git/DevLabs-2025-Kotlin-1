package tf.iitb.myapplication

fun kmToMiles(value: Int) {
    println("$value km(s) in ${"%.3f".format(value * 0.621)} mile(s).")
}

fun milesToKm(value: Int) {
    println("$value mile(s) in ${"%.3f".format(value / 0.621)} km(s).")
}

fun cToF(value: Int) {
    println("$value°C in ${"%.3f".format((value * 9.0 / 5) + 32)}°F.")
}

fun fToC(value: Int) {
    println("$value°F in ${"%.3f".format((value - 32) * 5.0 / 9)}°C.")
}

fun kgToLb(value: Int) {
    println("$value kg(s) in ${"%.3f".format(value * 2.20462)} lb(s).")
}

fun lbToKg(value: Int) {
    println("$value lb(s) in ${"%.3f".format(value / 2.20462)} kg(s).")
}

fun unitConverter() {
    println("Select the type of Unit Conversion: ")
    println("1. Kilometers(km) to Miles")
    println("2. Miles to Kilometers(km)")
    println("3. Centigrade(°C) to Fahrenheit(°F)")
    println("4. Fahrenheit(°F) to Centigrade(°C)")
    println("5. Kilograms(kg) to Pounds(lb)")
    println("6. Pounds(lb) to Kilograms(kg)")

    val choice = readln().toIntOrNull()

    if (choice != null) {
        println("Enter the value: ")
        val value = readln().toIntOrNull()
        if (value != null) {
            when (choice) {
                1 -> kmToMiles(value)
                2 -> milesToKm(value)
                3 -> cToF(value)
                4 -> fToC(value)
                5 -> kgToLb(value)
                6 -> lbToKg(value)
                else -> println("Invalid Choice.")
            }
        }
        else
        {
            println("Invalid Value.")
        }
    }
    else
    {
        println("Invalid Choice.")
    }
}
