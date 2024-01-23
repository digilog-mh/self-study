package javaToKotlin.lv2

import java.util.LinkedList
import java.util.Queue


var dx = intArrayOf(0, 1, 0, -1)
var dy = intArrayOf(1, 0, -1, 0)
lateinit var visited: Array<BooleanArray>
var row = 0
var colum = 0


fun groupLand(land: Array<IntArray>, xy: List<String>): Int {
    var mount=0

    for (code in xy){
        val arrCode = code.split(",".toRegex()).toTypedArray()
        val x = arrCode[0].toInt()
        val y = arrCode[1].toInt()
        val queue: Queue<IntArray> = LinkedList() // << Queue<int[]> = new LinkedList<>;

        if (!visited[x][y]){
            queue.offer(intArrayOf(x,y))
            visited[x][y] = true
            mount++

            while (!queue.isEmpty()){
                var now = queue.poll()

                for (i in 0 until 4){
                    var mx = now[0] + dx[i]
                    var my = now[1] + dx[i]

                    if (mx >=0 && my >=0 && mx < row && my < colum){
                        if (land[mx][my] ==1 && !visited[mx][my]){
                            visited[mx][my] = true
                            mount++
                            queue.add(intArrayOf(mx,my))
                        }
                    }
                }
            }
        }
    }

    return mount
}

fun solution(land: Array<IntArray>): Int {
    var answer =0
    row = land.size
    colum = land[0].size

    for (a in 0 until colum){
        var xy = mutableListOf<String>()

        for (b in 0 until row){
            if (land[b][a] == 1){
                xy.add("$b,$a")
            }
        }

        visited = Array(row){ BooleanArray(colum) } // visited = new boolean[row][colum]

        val mount = groupLand(land,xy)
        if (answer < mount) answer = mount
    }

    return answer
}

fun main() {
    var result=0
    val land = arrayOf(
        intArrayOf(0, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 1, 1, 0, 0),
        intArrayOf(1, 1, 0, 0, 0, 1, 1, 0),
        intArrayOf(1, 1, 1, 0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 0, 0, 0, 1, 1)
    )

    result = solution(land)
    println("result = $result")
}