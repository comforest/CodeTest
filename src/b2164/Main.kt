package b2164 // https://www.acmicpc.net/problem/2164

import java.util.LinkedList
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    val list = LinkedList<Int>()

    repeat(n) {
        list.add(it + 1)
    }

    while (list.size > 2) {
        list.removeFirst()
        val data = list.removeFirst()
        list.add(data)
    }

    println(list.last())
}
