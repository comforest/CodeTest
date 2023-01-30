package b11660

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val n = nextInt()
    val testCase = nextInt()

    val map = Array(n) { IntArray(n) { nextInt() } }
    val sumMap = Array(n) { IntArray(n) }

    repeat(n) { y ->
        var lineSum = 0
        repeat(n) { x ->
            lineSum += map[y][x]
            if (y == 0) {
                sumMap[y][x] = lineSum
            } else {
                sumMap[y][x] = sumMap[y - 1][x] + lineSum
            }
        }
    }

    repeat(testCase) {
        val y1 = nextInt() - 1
        val x1 = nextInt() - 1
        val y2 = nextInt() - 1
        val x2 = nextInt() - 1

        var answer = sumMap[y2][x2]
        if (x1 > 0) answer -= sumMap[y2][x1 - 1]
        if (y1 > 0) answer -= sumMap[y1 - 1][x2]
        if (x1 > 0 && y1 > 0) answer += sumMap[y1 - 1][x1 - 1]

        println(answer)
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