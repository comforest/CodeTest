package b9935

import java.util.LinkedList
import java.util.Scanner
import java.util.Stack


fun main() {
    val scanner = Scanner(System.`in`)

    val input = scanner.nextLine()
    val explosion = scanner.nextLine()

    val stack = Stack<Char>()

    for (c in input) {
        stack.add(c)

        if(checkExplosion(stack, explosion)){
            repeat(explosion.length){
                stack.pop()
            }
        }
    }

    val str = String(stack.toCharArray())

    println(
        if (stack.isNotEmpty())
            str
        else
            "FRULA"
    )
}

private fun checkExplosion(str: List<Char>, ex: String): Boolean {
    val strLength = str.size
    val exLength = ex.length

    if(strLength < exLength) return false

    for (i in ex.indices) {
        if (ex[exLength - 1 - i] != str[strLength - 1 - i]) return false
    }

    return true
}


