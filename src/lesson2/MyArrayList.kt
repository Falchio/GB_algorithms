package lesson2


private const val DEFAULT_CAPACITY = 10

data class MyArrayList<T : Comparable<T>>(var capacity: Int = DEFAULT_CAPACITY) : Cloneable {
    var list: Array<T>
    var size: Int = 0

    init {
        require(capacity > 0) { "capacity<=0" }
        list = arrayOfNulls<Comparable<*>>(capacity) as Array<T>
    }

    fun add(item: T) {
        increaseCapacityIfNeeded()
        list[size] = item
        size++
    }


    fun size(): Int {
        return size
    }

    fun get(index: Int): T {
        require(index <= capacity) { "index > list size" }
        return list[index]
    }

    fun lenght(): Int {
        return list.size
    }

    fun add(index: Int, item: T) {
        require(index <= capacity) { "index > list size" }
        increaseCapacityIfNeeded()
        for (i in size downTo index + 1) {
            list[i] = list[i - 1]
        }
        list[index] = item
        size++
    }

    private fun increaseCapacityIfNeeded() {
        if (size + 1 >= capacity) {
            increaseCapacity()
        }
    }

    private fun increaseCapacity() {
        val newCapacity: Int = getNewCapacity(capacity)
        val newList: Array<T> = arrayOfNulls<Comparable<T>>(newCapacity) as Array<T>
        val startPosition = 0
        System.arraycopy(list, startPosition, newList, startPosition, size)
        list = newList
        capacity = newCapacity
    }

    private fun getNewCapacity(capacityFactor: Int): Int {
        val coefficient = 1.5
        val magicInt = 1
        return (capacityFactor * coefficient + magicInt).toInt()
    }

    override fun toString(): String {
        val sb = StringBuilder("[")
        for (i in 0 until size) {
            sb.append(list[i]).append(", ")
        }
        if (size > 0) {
            sb.setLength(sb.length - 2)
        }
        sb.append("]")
        return sb.toString()
    }

    fun selectionSort() {
        var min: Int
        for (i in 0 until size - 1) {
            min = i
            for (j in i + 1 until size) {
                if (list[j] < list[min]) {
                    min = j
                }
            }
            swap(i, min)
        }
    }

    private fun swap(index1: Int, index2: Int) {
        val temporaryItem = list[index1]
        list[index1] = list[index2]
        list[index2] = temporaryItem
    }

    fun insertionSort() {
        var key: T
        for (i in 1 until size) {
            var j = i
            key = list[i]
            while (j > 0 && key < list[j - 1]) {
                list[j] = list[j - 1]
                j--
            }
            list[j] = key
        }
    }

    fun bubbleSort() {
        var isSwap: Boolean
        for (i in size - 1 downTo 1) {
            isSwap = false
            for (j in 0 until i) {
                if ((list[j + 1] < list[j])) {
                    swap(j + 1, j)
                    isSwap = true
                }
            }
            if (!isSwap) {
                break
            }
        }
    }

    public override fun clone(): MyArrayList<T> {
        val myArrayList = MyArrayList<T>()
        myArrayList.size = this.size
        myArrayList.capacity = this.capacity
        myArrayList.list = this.list.clone()
        return myArrayList
    }

}
