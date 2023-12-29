class ch2{
    companion object {
        fun testArray() {
            val a = arrayOf("0","1","2","3","4")
            val b = Array(5, {i -> i.toString()}) //Array의 팩토리 함수.

            for (c in a){
                print(c)
            }

            println()

            for (c in b){
                print(c)
            }
        }
    }
}

fun test(){
    var a: Int = 10000
    var b: Int? = 10000

    println("a===b: ${a===b}")
    println("a==b: ${a==b}")

    val c:Int =1
    val x:Long = c.toLong()

    println("x = ${x}")

    val str:String = """ "'tes't\\// """ //특수문자에 대해 escape 처리 해줄 필요 없이 """ """ 로 감싸면 그 내부의 문자는 그대로 출력이 됨.
    println(str)
}
fun main() {
    //ch2.testArray()
    //test()
}