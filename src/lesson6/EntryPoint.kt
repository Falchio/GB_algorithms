package lesson6

fun main() {
    val listOfTrees = mutableListOf<MyTreeMap<Int, String>>()
    while (listOfTrees.size <= 100_000) {
        val map = MyTreeMap<Int, String>()
        while (map.height() < 6) {
            val number = (-100..100).random()
            map.put(number, number.toString())
//            println("put: $number, map height: ${map.height()}")
        }
        listOfTrees.add(map)
    }

    val balanced: Int = listOfTrees.find { item -> item.isBalanced }?.size() ?: 0
    println("Balanced: $balanced")
    println("Сбалансированных деревьев: ${(balanced.toDouble()/listOfTrees.size.toDouble()) * 100} %")
}
// balanced tree
//    val map = MyTreeMap<Int, String>()
//        .apply {
//            put(5,"5")
//            put(10,"10")
//            put(3,"3")
//            put(4,"4")
//            put(1,"1")
//            put(11,"11")
//            put(6,"6")
//            put(12,"12")
//         }
