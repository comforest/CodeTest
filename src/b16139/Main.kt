package b16139

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val str = next()
    val testCase = nextInt()

    val arr = Array(str.length) { IntArray(26) }

    arr[0][str[0] - 'a'] = 1

    for (i in 1 until str.length) {
        repeat(26) { j ->
            arr[i][j] = arr[i - 1][j]
        }
        arr[i][str[i] - 'a'] += 1
    }

    val outputBuilder = StringBuilder()
    repeat(testCase) {
        val alpha = next()[0] - 'a'
        val start = nextInt()
        val end = nextInt()

        outputBuilder.append(
            if (start == 0) arr[end][alpha]
            else arr[end][alpha] - arr[start - 1][alpha]
        )
        outputBuilder.append('\n')
    }
    println(outputBuilder.toString())
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