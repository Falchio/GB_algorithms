package lesson4

class MyLinkedQueue<T> {
    private val myLinkedList = MyLinkedList<T>()

    fun insert(item: T) {
        myLinkedList.insertFirst(item)
    }

    fun remove() {
        myLinkedList.removeLast()
    }

    fun isEmpty(): Boolean {
        return myLinkedList.isEmpty
    }

    fun size(): Int {
        return myLinkedList.size()
    }
}