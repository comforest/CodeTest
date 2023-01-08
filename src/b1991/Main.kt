package b1991

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null
private var input: String = ""

fun main() {
    val n = nextInt()

    val list = List(n) { Node('A' + it) }

    repeat(n) {
        val p = nextChar()
        val l = nextChar()
        val r = nextChar()

        val node = list[p - 'A']
        if(l != '.') node.left = list[l - 'A']
        if(r != '.') node.right = list[r - 'A']
    }

    preOrder(list[0])
    println()
    inOrder(list[0])
    println()
    postOrder(list[0])
}

fun preOrder(node: Node?){
    if(node == null) return
    print(node.label)
    preOrder(node.left)
    preOrder(node.right)
}

fun inOrder(node: Node?){
    if(node == null) return
    inOrder(node.left)
    print(node.label)
    inOrder(node.right)
}

fun postOrder(node: Node?){
    if(node == null) return
    postOrder(node.left)
    postOrder(node.right)
    print(node.label)
}


class Node(
    val label: Char,
    var parent: Node? = null,
    var left: Node? = null,
    var right: Node? = null,
)

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

private fun nextChar(): Char {
    return next()[0]
}