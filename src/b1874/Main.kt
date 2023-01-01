package b1874

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
                push(input)
            else
                pop(input)

            prev = input
        }
        print.forEach(::println)
    } catch (e: InvalidException) {
        println("NO")
    }
}

fun push(n: Int) {
    while (index <= n) {
        print.add('+')
        stack.add(index++)
    }
    pop(n)
}

fun pop(n: Int) {
    if(stack.isEmpty() || stack.last() != n) throw InvalidException
    print.add('-')
    stack.removeLast()
}

object InvalidException : Exception()