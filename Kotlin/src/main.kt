
fun main(args: Array<String>) {

    fun(a: Int, b: Int): Int
    {
        return a+b
    }

    fun parseInt(str: String): Int? {
        return  str.toInt();
    }

    fun getSTringLen(obj: Any): Int? {
        if (obj is String) return obj.length

        return null;
    }

    fun whenExpress(obj: Any): String =
        when(obj){
            1 -> "one"
            is Long -> "Long"
            !is String -> "not string"
            else -> "unknown"
        }

    val items = listOf("apple","orange","banana", "avocado")
    for (item in items){
        println(item)
    }

    when{
        "orange" in items -> println("in items")
    }

    items.filter { it.startsWith("a")}
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { print(it+"-") }

}