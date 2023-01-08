package `b1024`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val sum = nextInt()
    val length = nextInt()

    for (i in length..100) {
        if(sum / i - (i - 1) / 2 < 0) continue
        if (i % 2 == 1) {
            if (sum % i == 0) {
                printAnswer(sum / i - (i - 1) / 2, i)
                return
            }
        } else if (sum % i == i / 2) {
            printAnswer(sum / i - (i - 1) / 2, i)
            return
        }
    }
    println(-1)
}

fun printAnswer(a: Int, n: Int) {
    repeat(n) {
        print("${a + it} ")
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