package b10986

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val size = nextInt()
    val m = nextInt()

    val arr = IntArray(size) { nextInt() }

    val sum = IntArray(size)
    val map = IntArray(m)
    sum[0] = arr[0] % m

    for (i in 1 until size) {
        sum[i] = sum[i - 1] + arr[i]
        sum[i] %= m
    }


    repeat(size) { i ->
        ++map[sum[i]]
    }

    var answer : Long = map[0].toLong()

    repeat(m) { i ->
        val n = map[i].toLong() * (map[i] - 1)
        answer += n.shr(1)
    }

    println(answer)
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