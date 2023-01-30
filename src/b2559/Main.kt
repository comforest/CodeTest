package b2559

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val size = nextInt()
    val sumSize = nextInt()

    val arr = IntArray(size) {
        nextInt()
    }

    var pos = 0
    repeat(sumSize) {
        pos += arr[it]
    }
    var max = pos

    for (i in sumSize until size) {
        pos += arr[i] - arr[i - sumSize]
        if(max < pos) max = pos
    }

    println(max)
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