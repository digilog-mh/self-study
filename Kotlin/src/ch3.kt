
class ch3 {
    val data = listOf(1,2,3,4,5)
    var idx=0

    operator fun hasNext(): Boolean{
        return data.size > idx
    }

    operator fun next():Int{
        return data[idx++]
    }
}

class MyData{
    operator fun iterator(): ch3{
        return ch3()
    }
}

fun flow(a:Int, b:Int): Unit {
    val max = if (a > b) a else b

    val max2 = if (a >b){
        println("choose a: ${a}")
        a
    }else{
        println("choose b: ${b}")
        b
    }

    println("max: ${max2}")

    when(a){
        1-> println("a==1")
        2-> println("a==2")
        10-> println("a==10")
        else->{
            println("not found")
        }
    }

    //when 사용시, 여러 조건들을 넣을 수 있음.
    when(a){
        1, 10-> println("a is 1 or 10")
        2 -> println("2")
    }

    //branch의 조건문에 함수나 식을 사용할 수 있음.
    when(a){
        7+3-> println("a = 7+3") // a = 10인경우의 조건.
        else-> println("???")
    }

    val numbers = listOf(3,6,9)
    when(a){
        in numbers-> println("a in numbers") //리스트내 포함여부.
        in 1..10 -> println("a in range 1 to 10") //범주 설정.
        !in 11..20 -> println("a not in range 11 to 20")
        else-> println("???")
    }

    when{
        hasPrefix(1111) -> println("String")
        else-> println("not String")
    }

    //for Loop
    for (num in numbers){
        println(num)
    }

    val array = arrayOf("a","b","c")
    for (i in array.indices){
        println("$i: ${array[i]}")
    }

    for ((i,v) in array.withIndex()){
        println("$i: $v")
    }

}

fun hasPrefix(x: Any) = when(x){
    is String-> x.startsWith("prefix")
    else -> false

}

fun main() {
    //flow(10, 5)
    /*val myData = MyData()
    for (item in myData)
        println(item)*/
}