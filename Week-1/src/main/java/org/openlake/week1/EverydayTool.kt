package org.openlake.week1

import calculator
import tf.iitb.myapplication.unitConverter

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
            1 -> unitConverter()
            2 -> calculator()
            3 -> bmiCalculator()
            4 -> ReportCard.run()
            5 -> {
                println("Goodbye!")
                return
            }
            else -> println("Invalid option. Try again.")
        }
    }
}