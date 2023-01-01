package b17299

import java.util.Scanner
import java.util.Stack

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val arr = IntArray(n)
    val countMap = hashMapOf<Int, Int>()

    repeat(n) {
        val num = scanner.nextInt()
        arr[it] = num
        countMap[num] = (countMap[num] ?: 0) + 1
    }

    val stack = Stack<Data>()
    val answer = IntArray(n) { -1 }

    arr.forEachIndexed { index, num ->
        val count = countMap[num]!!
        while (stack.isNotEmpty() && stack.peek().count < count){
            answer[stack.pop().index] = num
        }
        stack.add(Data(index, count))
    }

    answer.forEach {
        print("$it ")
    }
}

data class Data(
    val index: Int,
    val count: Int,
)