package b9012

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    scanner.nextLine()

    repeat(n) {
       val input = scanner.nextLine()
        println(
            if (readOneLine(input))
                "YES"
            else
                "NO"
        )
    }
}

fun readOneLine(input: String): Boolean {
    val stack = mutableListOf<Char>()

    for (char in input){
        if(char == '(') stack.add('(')
        else if(stack.isNotEmpty() && stack.last() == '(') stack.removeLast()
        else return false
    }

    return stack.isEmpty()
}