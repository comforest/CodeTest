package b10773

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val list = mutableListOf<Int>()

    repeat(n){
       val input = scanner.nextInt()

        if(input == 0)
            list.removeLast()
        else
            list.add(input)
    }

    println(list.sum())
}