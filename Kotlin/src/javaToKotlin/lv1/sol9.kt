


fun solution(n: Int): Int {
    var answer =0
    var i=1

    while (true){
        if (n%i == 1){
            answer = i
            break
        }else{
            i++
        }

        if(i>n) break
    }

    return answer
}

fun main() {

    var result=0

    result=solution(10)
    println("result = ${result}") //3

    result=solution(12)
    println("result = ${result}") //11

}