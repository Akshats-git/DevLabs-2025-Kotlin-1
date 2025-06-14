package org.openlake.week1

object ReportCard {

    private val marks = mutableListOf<Int>()

    fun run() {
        println()
        while(true) {
            println("📕Report Card Menu")
            println("1. Enter Grades")
            println("2. View Report Card")
            println("3. Back to Main Menu")
            print("Choose an option: ")

            when (readlnOrNull()?.toIntOrNull()) {
                1 -> enterGrades()
                2 -> viewReportCard()
                3 -> return
                else -> {
                    println("Invalid option. Try again.")
                    println()
                }
            }
        }
    }

    private fun enterGrades() {
        println()
        println("Entering grades...")
        marks.clear()
        print("Enter the number of subjects (3 to 5): ")

        while(true) {
            val numSubjects = readLine()?.toIntOrNull()

            if (numSubjects != null && numSubjects in 3..5) {
                var i=1
                while (i in 1..numSubjects) {
                    print("Enter marks for subject $i: ")
                    val mark = readLine()?.toIntOrNull()
                    if (mark != null && mark in 0..100) {
                        marks.add(mark)
                        i++
                    } else {
                        println("Invalid mark. Please enter a value between 0 and 100.")
                    }
                }
                println("Grades entered successfully!")
                break
            } else {
                print("Invalid number of subjects. Please enter a value between 3 and 5: ")
                continue
            }
        }
        println()
    }

    private fun viewReportCard() {
        println()
        if (marks.isEmpty()) {
            println("No grades entered yet.")
            println()
            return
        }

        val total = marks.sum()
        val average = total / marks.size.toDouble()

        println("Viewing report card...")
        println("Total marks: $total")
        println("Average marks: $average")

        val grade = when {
            average >= 90 -> "A"
            average >=80 -> "A-"
            average >=70 -> "B"
            average >= 60 -> "B-"
            average >= 50 -> "C"
            average >= 40 -> "C-"
            average >= 30 -> "D"
            else -> "F"
        }

        println("Grade: $grade")
        println()
    }

}
