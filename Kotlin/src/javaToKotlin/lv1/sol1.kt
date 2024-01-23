package javaToKotlin.lv1

class sol1 {
    /*
    int[] > IntArray
    int[][] > Array<IntArray>
    변수 선언시, 타입형 정의 안해도됨.
    */

}
fun solution(bandage:IntArray, health:Int, attacks:Array<IntArray>): Int{
    val minCnt = bandage[0]
    val secHeal = bandage[1]
    val bonusHeal = bandage[2]

    var status = health;
    var interverSec = 0;

    for (i in 0 until attacks.size){
        var attSec = attacks[i][0]
        var attNum = attacks[i][1]

        if (status == health){
            status -= attNum
        }else{
            interverSec = attSec - attacks[i-1][0] -1;
            status += interverSec * secHeal

            if (interverSec >= minCnt) status += (interverSec/minCnt) * bonusHeal

            if (status > health) status = health - attNum
            else status -= attNum
        }

        if (status <1) {
            status = -1
            break
        }
    }

    return status
}

fun main() {
    var result = 0

    result = solution(intArrayOf(5,1,5), 30, arrayOf( intArrayOf(2,10), intArrayOf(9,15), intArrayOf(10,5), intArrayOf(11,5)))
    println("result = ${result}") //5

    result = solution(intArrayOf(3,2,7), 20, arrayOf( intArrayOf(1,15), intArrayOf(5,16), intArrayOf(8,6)))
    println("result = ${result}") //-1

    result = solution(intArrayOf(4,2,7), 20, arrayOf( intArrayOf(1,15), intArrayOf(5,16), intArrayOf(8,6)))
    println("result = ${result}") //5

    result = solution(intArrayOf(1,1,1), 5, arrayOf( intArrayOf(1,2), intArrayOf(3,2)))
    println("result = ${result}") //5

}