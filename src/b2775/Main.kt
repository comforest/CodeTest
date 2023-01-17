package b2775

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

private const val MAX_SIZE = 15

fun main() {
    val map = MutableList(MAX_SIZE) { MutableList(MAX_SIZE) { 0 } }

    repeat(MAX_SIZE) {
        map[0][it] = it + 1
        map[it][0] = 1
    }

    for (floor in 1 until MAX_SIZE) {
        for (room in 1 until MAX_SIZE) {
            map[floor][room] = map[floor][room-1] + map[floor - 1][room]
        }
    }

    val testCase = nextInt()
    repeat(testCase) {
        val floor = nextInt()
        val room = nextInt() - 1
        println(map[floor][room])
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