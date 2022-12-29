package b1026

import java.util.Scanner

const val MAX_INDEX = 100_000


data class Point(
    val index: Int,
    val time: Int,
)
fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    val list1 = List(n){scanner.nextInt()}
    val list2 = List(n){scanner.nextInt()}

    val ascList1 = list1.sorted()
    val descList2 = list2.sortedDescending()

    var sum = 0
    repeat(n){
        sum += ascList1[it] * descList2[it]
    }

    println(sum)
}
