package b2566

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

private const val LENGTH = 9

fun main() {
    var maxValue = -1
    var answerX = 0
    var answerY = 0

    repeat(LENGTH) { x ->
        repeat(LENGTH) { y ->
            val v = nextInt()
            if(maxValue < v){
                maxValue = v
                answerX = x + 1
                answerY = y + 1
            }
        }
    }
    println(maxValue)
    println("$answerX $answerY")
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