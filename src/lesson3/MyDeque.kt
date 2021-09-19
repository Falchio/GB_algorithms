package lesson3

private const val DEFAULT_CAPACITY = 10

class MyDeque<T>(private var capacity: Int = DEFAULT_CAPACITY) {
    private var array: Array<T?>
    private var size: Int = 0
    private var head: Int = 0
    private var tail: Int = 0


    init {
        require(capacity > 0) { "capacity<=0" }
        array = arrayOfNulls<Any>(capacity) as Array<T?>
    }

    fun insertFirst(item: T?) {
        ensureCapacity(size + 1)
        head = decremented(head)
        array[head] = item
        size++
    }

    fun insertLast(item: T?) {
        ensureCapacity(size + 1)
        array[internalIndex(size)] = item
        size++
    }

    fun removeFirst(): T? {
        if (isEmpty()) throw NoSuchElementException("ArrayDeque is empty.")
        val temp = array[head]
        array[head] = null
        head = incremented(head)
        size -= 1
        return temp
    }

    fun removeLast(): T? {
        if (isEmpty()) throw NoSuchElementException("ArrayDeque is empty.")

        val internalLastIndex = internalIndex(size-1)
        val element = array[internalLastIndex]
        array[internalLastIndex] = null
        size -= 1
        return element
    }


    private fun ensureCapacity(minCapacity: Int) {
        if (minCapacity < 0) throw IllegalStateException("Illegal capacity $minCapacity")    // overflow
        if (minCapacity <= array.size) return

        val newCapacity = (minCapacity * 1.5 + 1).toInt()
        copyElements(newCapacity)
    }

    private fun copyElements(newCapacity: Int) {
        val newElements = arrayOfNulls<Any?>(newCapacity) as Array<T?>
        array.copyInto(newElements, 0, head, array.size)
        array.copyInto(newElements, array.size - head, 0, head)
        head = 0
        array = newElements
    }

    fun isEmpty(): Boolean = size == 0

    fun size() = size


    private fun nextIndex(index: Int): Int {
        return (index + 1) % array.size
    }

    private fun decremented(index: Int): Int = if (index == 0) array.lastIndex else index - 1
    private fun incremented(index: Int): Int = if (index == array.lastIndex) 0 else index + 1

    private fun internalIndex(index: Int): Int = positiveMod(head + index)
    private fun positiveMod(index: Int): Int = if (index >= array.size) index - array.size else index
}