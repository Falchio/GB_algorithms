package lesson6

fun main(){
    val map = MyTreeMap<Int, String>()
        .apply {
            put(5,"5")
            put(10,"10")
            put(3,"3")
            put(4,"4")
            put(1,"1")
            put(11,"11")
            put(6,"6")
         }

    println(map.height())
    println(map)

}