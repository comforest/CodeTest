package b11866

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val n = nextInt()
    val k = nextInt()

    print("<")

    val list = LinkedList<Int>()
    repeat(n){
        list.add(it+1)
    }

    while (list.size > 1){
        repeat(k - 1){
            val n = list.pop()
            list.add(n)
        }
        print("${list.pop()}, ")
    }

    print(list.last)

    print(">")
}

fun next(): String {
    if (st == null || st!!.hasMoreTokens().not()) {

        input = br.readLine()
        st = StringTokenizer(input, " ");
    }

    return st!!.nextToken()
}

fun nextInt(): Int {
    return next().toInt()
}