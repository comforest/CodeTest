package b11659

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val size = nextInt()
    val testCase = nextInt()

    val arr = IntArray(size)

    repeat(size) {
        arr[it] = nextInt() + if (it > 0) arr[it - 1] else 0
    }

    repeat(testCase) {
        val start = nextInt() - 1
        val end = nextInt() - 1

        if(start == 0) println(arr[end])
        else println(arr[end] - arr[start - 1])
    }
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