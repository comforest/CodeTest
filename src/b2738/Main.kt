package b2738

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val height = nextInt()
    val width = nextInt()

    val first = MutableList(width) { MutableList(height) { 0 } }

    repeat(height) { h ->
        repeat(width) { w ->
            first[w][h] = nextInt()
        }
    }

    repeat(height) { h ->
        repeat(width) { w ->
            print("${first[w][h] + nextInt()} ")
        }
        println()
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