package b15828

import java.util.LinkedList
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()
    val list = LinkedList<Int>()

    while (true) {
        when (val input = scanner.nextInt()) {
            -1 -> break
            0 -> list.removeFirst()
            else -> if(list.size < size) list.add(input)
        }

    }

    list.forEach {
        print("$it ")
    }

    if(list.isEmpty())
        println("empty")
}