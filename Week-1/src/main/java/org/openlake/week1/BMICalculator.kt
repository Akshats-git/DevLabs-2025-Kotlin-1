package org.openlake.week1


fun main() {
    print("Enter your weight(kg) : ")
    val weight = readln()?.toDoubleOrNull()
    print("Enter your height(m) : ")
    val height = readln()?.toDoubleOrNull()

    if (weight != null && height != null && weight > 0 && height > 0) {
        val bmi = weight / (height * height)
        println("Your BMI is : %.2f".format(bmi))

        when {
            bmi < 18.5 -> println("You are underweight.")
            bmi in 18.5..24.9 -> println("You have a normal weight.")
            bmi in 25.0..29.9 -> println("You are overweight.")
            else -> println("You are obese.")
        }
    }
    else {
        println("Invalid input. Please enter valid numbers for weight and height.")
    }
}