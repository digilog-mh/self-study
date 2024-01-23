package ch

class ch4 {
}

//암시적 레이블 사용.
fun foo4(){
    var nums = listOf(0,1,2,3)
    nums.forEach{
        if (it == 1) return@forEach
        print(it)
    }

    println("--4--")
}

//레이블 사용.
fun foo3(){
    var nums = listOf(0,1,2,3)
    nums.forEach label@ {
                    if (it == 1) return@label
                    print(it)
                }

    println("--3--")
}

fun foo2(){
    var nums = listOf(0,1,2,3)
    nums.forEach(
        { //람다식
            if (it==1) return
            print(it)
        }
    )
    println("---")
}

fun foo1(){
    var nums = listOf(0,1,2,3)
    nums.forEach(
        fun (v: Int){
            if (v == 1) return
            print(v)
        }
    )
    println("")
}

fun main() {
    //printOther2()
    //foo1()
    //foo2()
    //foo3()
    foo4()
}

