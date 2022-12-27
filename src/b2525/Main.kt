package b2525

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var hour = scanner.nextInt()
    var min = scanner.nextInt()
    val needTime = scanner.nextInt()

    hour += needTime / 60
    min += needTime % 60

    while (min >= 60) {
        min -= 60
        hour++
    }

    while(hour >= 24){
        hour -= 24
    }

    println("$hour $min")
}