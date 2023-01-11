package b24060

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.system.exitProcess

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val n = nextInt()
    k = nextInt()
    val arr = IntArray(n) { nextInt() }

    countMergeSort(arr)

    println("-1")
}

var k: Int = 0

private fun countMergeSort(arr: IntArray, left: Int = 0, right: Int = arr.size - 1, count: Int = 0): Int {
    if (left >= right) return 0
    val mid = (left + right) / 2

    val a = countMergeSort(arr, left, mid, count)
    val b = countMergeSort(arr, mid + 1, right, count + a)
    val c = right - left + 1

    if (c >= k - (count + a + b)) {
        find(arr, left, right, k - count - a - b)
    }
    return a + b + c
}

private fun find(arr: IntArray, left: Int, right: Int, index: Int) {
    var minIndex = findMinIndex(arr, left, right, index)

    repeat(index-1) {
        arr[minIndex] = Int.MAX_VALUE
        for (i in left..right) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i
            }
        }
    }
    println(arr[minIndex])
    exitProcess(0)
}

private fun findMinIndex(arr: IntArray, left: Int, right: Int, index: Int): Int {
    var index = left
    for (i in left..right) {
        if (arr[i] < arr[index]) {
            index = i
        }
    }
    return index
}

private fun next(): String {
    if (st == null || st!!.hasMoreTokens().not()) {

        input = br.readLine()
        st = StringTokenizer(input, " ");
    }

    return st!!.nextToken()
}

private fun nextInt(): Int {
    return next().toInt()
}