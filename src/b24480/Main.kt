package b24480

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val vertexCount = nextInt()
    val edgeCount = nextInt()
    val startVertex = nextInt() - 1

    val graph = MutableList(vertexCount){ mutableListOf<Int>() }

    repeat(edgeCount){
        val a = nextInt() - 1
        val b = nextInt() - 1

        graph[a].add(b)
        graph[b].add(a)
    }

    graph.forEach {
        it.sortDescending()
    }

    val answer = IntArray(vertexCount)
    dfs(startVertex, graph, answer)

    val stringBuilder = StringBuilder()
    answer.forEach {
        stringBuilder.append("$it\n")
    }
    println(stringBuilder)
}

var index = 1

private fun dfs(v: Int, graph: List<List<Int>>, answer: IntArray) {
    if (answer[v] != 0) return
    answer[v] = index++
    for (nextVertex in graph[v]) {
        if (answer[nextVertex] != 0) continue
        dfs(nextVertex, graph, answer)
    }
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