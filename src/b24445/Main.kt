package b24445

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
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
    bfs(startVertex, graph, answer)

    val stringBuilder = StringBuilder()
    answer.forEach {
        stringBuilder.append("$it\n")
    }
    println(stringBuilder)
}

var index = 1
private fun bfs(start: Int, graph: List<List<Int>>, answer: IntArray) {
    val que: Queue<Int> = LinkedList()
    que.add(start)
    while (!que.isEmpty()) {
        val v = que.poll()
        if (answer[v] != 0) continue
        answer[v] = index++
        for (vv in graph[v]) {
            if (answer[vv] != 0) continue
            que.add(vv)
        }
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