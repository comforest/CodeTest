package b4949

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        val input = scanner.nextLine()
        println(
            if (readOneLine(input))
                "yes"
            else
                "no"
        )
    }
}

fun readOneLine(input: String): Boolean {
    val stack = mutableListOf<Char>()

    for (char in input) {
        when (char) {
            '(' -> stack.add(')')
            '[' -> stack.add(']')
            ')', ']' -> if(!popStack(stack, char)) return false
        }
    }

    return stack.isEmpty()
}

fun popStack(stack: MutableList<Char>, input: Char): Boolean {
    if (stack.isEmpty() || stack.last() != input)
        return false

    stack.removeLast()
    return true
}