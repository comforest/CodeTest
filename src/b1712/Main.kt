package b1712

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val fixedCost = nextInt()
    val perCost = nextInt()
    val price = nextInt()

    if (perCost >= price) {
        println(-1)
        return
    }

    println(fixedCost / (price - perCost) + 1)
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