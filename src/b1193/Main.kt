package b1193

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val input = nextInt()
    var x = input
    var index = 1

    while (x > 0) {
        x -= index++
    }

    x += index - 1

    println(if (index % 2 == 1) "$x/${index - x}" else "${index - x}/$x")
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