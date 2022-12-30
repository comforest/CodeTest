package b1874

import b13549.InvalidException
import java.util.Scanner

val stack = mutableListOf<Int>()
val print = mutableListOf<Char>()
var index = 1
fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    try {
        var prev = 0
        repeat(n) {
            val input = scanner.nextInt()
            if (input > prev)
                b13549.push(input)
            else
                b13549.pop(input)

            prev = input
        }
        b13549.print.forEach(::println)
    } catch (e: InvalidException) {
        println("NO")
    }
}

fun push(n: Int) {
    while (b13549.index <= n) {
        b13549.print.add('+')
        b13549.stack.add(b13549.index++)
    }
    b13549.pop(n)
}

fun pop(n: Int) {
    if(b13549.stack.isEmpty() || b13549.stack.last() != n) throw InvalidException
    b13549.print.add('-')
    b13549.stack.removeLast()
}

object InvalidException : Exception()