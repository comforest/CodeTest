package b2869

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.ceil

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val day = nextInt()
    val night = nextInt()
    val length = nextInt()

    println(ceil((length.toDouble() - night) / (day - night)).toInt())
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