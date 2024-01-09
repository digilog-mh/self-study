package javaToKotlin


fun solution(board: Array<Array<String>>, h: Int, w:Int): Int {
    var answer =0;
    var color = board[h][w]
    var dx = arrayOf(0, 1, 0, -1)
    var dy = arrayOf(1,0,-1,0)
    val row = board.size
    val colum = board[0].size

    for (i in 0 until 4){
        var mx = h + dx[i]
        var my = w + dy[i]

        if (mx >= 0 && my >=0 && mx < row && my < colum){
            if (color.equals(board[mx][my])) answer++
        }
    }


    return answer;
}

fun main() {
    var result = 0;

    result = solution(arrayOf( arrayOf("blue", "red", "orange", "red"),
                                arrayOf("red", "red", "blue", "orange"),
                                arrayOf("blue", "orange", "red", "red"),
                                arrayOf("orange", "orange", "red", "blue")), 1, 1)
    println("result = ${result}")
}