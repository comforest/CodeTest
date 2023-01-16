package b10250

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.ceil

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val testCase = nextInt()

    repeat(testCase) { calc() }
}

private fun calc() {
    val height = nextInt()
    val width = nextInt()
    val n = nextInt()

    val x = ceil(n.toDouble() / height).toInt()
    var y = n % height
    if(y == 0) y = height

    if (x < 10) {
        println("${y}0$x")
    } else {
        println("$y$x")
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