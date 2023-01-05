package b16928

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val count = nextInt() + nextInt()

    val map = HashMap<Int, Int>(count)

    repeat(count) {
        map[nextInt()] = nextInt()
    }

    val heap = PriorityQueue(Comparator<Data> { o1, o2 -> o1.move.compareTo(o2.move) })
    val visited = hashSetOf<Int>()
    heap.add(Data(1, 0))

    while (true) {
        val d = heap.poll()
        if(visited.contains(d.position)) continue
        visited.add(d.position)

        for (i in 1..6) {
            val destination = move(map, d.position, i)
            if (destination == 100) {
                println(d.move + 1)
                return
            }
            if(visited.contains(destination)) continue
            heap.add(Data(destination, d.move + 1))
        }
    }
}

fun move(map: Map<Int, Int>, start: Int, move: Int): Int {
    val diceDepartment = start + move
    return map[diceDepartment] ?: diceDepartment
}

data class Data(
    val position: Int,
    val move: Int,
)

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