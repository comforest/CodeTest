package b13549

import java.util.PriorityQueue
import java.util.Scanner

const val MAX_POSITION = 100_000

fun main() {
    val scanner = Scanner(System.`in`)

    val start = scanner.nextInt()
    val end = scanner.nextInt()

    val heap = PriorityQueue<Point> { o1, o2 -> o1.time.compareTo(o2.time) }
    val set = hashSetOf<Int>()

    heap.add(Point(start, 0))

    while (heap.isNotEmpty()) {
        val point = heap.poll()
        val p = point.position
        val t = point.time

        if (p == end){
            println(t)
            return
        }
        if (set.contains(p)) continue
        set.add(p)

        checkAndProcess(heap, set, Point(p * 2, t))
        checkAndProcess(heap, set, Point(p + 1, t + 1))
        checkAndProcess(heap, set, Point(p - 1, t + 1))
    }
}

fun checkAndProcess(heap: PriorityQueue<Point>, set: Set<Int>, point: Point) {
    if (point.position > MAX_POSITION + 5) return
    if (set.contains(point.position)) return
    heap.add(point)
}

data class Point(
    val position: Int,
    val time: Int,
)