package b2563

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val n = nextInt()
    val map = Array<BooleanArray>(100) {
        BooleanArray(100)
    }

    repeat(n) {
        val x = nextInt()
        val y = nextInt()
        repeat(10) { xx ->
            repeat(10) { yy ->
                map[x + xx][y + yy] = true
            }
        }
    }

    val answer = map.toList().sumOf { array ->
        array.count {
            it
        }
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