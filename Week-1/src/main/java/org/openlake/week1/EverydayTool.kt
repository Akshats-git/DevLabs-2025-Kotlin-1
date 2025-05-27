package org.openlake.week1

fun main() {
    while (true) {
        println("\n🛠 Everyday Tools Menu")
        println("1. Unit Converter")
        println("2. Calculator")
        println("3. BMI Calculator")
        println("4. Report Card")
        println("5. Exit")
        print("Choose an option: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> UnitConverter.run()
            2 -> Calculator.run()
            3 -> BMICalculator.run()
            4 -> ReportCard.run()
            5 -> {
                println("Goodbye!")
                return
            }
            else -> println("Invalid option. Try again.")
        }
    }
}