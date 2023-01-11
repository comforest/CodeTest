package b25501

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val n = nextInt()

    repeat(n){
        println(isPalindrome(next()))
    }
}

private fun isPalindrome(str: String, left: Int = 0, right: Int = str.length - 1): Int {
    return if (left >= right) {
        print("1 ")
        1
    } else if (str[left] != str[right]) {
        print("0 ")
        1
    } else {
        isPalindrome(str, left + 1, right - 1) + 1
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