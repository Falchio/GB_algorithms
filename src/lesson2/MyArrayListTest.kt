package lesson2

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MyArrayListTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }


    @Test
    @DisplayName("Test adding item in array")
    fun add() {
        val myArrayList = MyArrayList<Int>(1)
        myArrayList.add(1)
        val item = myArrayList.get(0)
        assertEquals(1, item)
    }

    @Test
    @DisplayName("Test array size")
    fun size() {
        val myArrayList = MyArrayList<Int>(1)
        assertEquals(0, myArrayList.size())
        myArrayList.add(1)
        assertEquals(1, myArrayList.size())
    }

    @Test
    @DisplayName("Test add item at index")
    fun testAddingByIndex() {
        val myArrayList = MyArrayList<Int>()
        val index = 9
        myArrayList.add(index, 41)
        assertEquals(41, myArrayList.get(index))
    }

    @Test
    @DisplayName("Test add item over capacity")
    fun testAddElementOverCapacity() {
        val firstItem = 1
        val secondItem = 2
        val thirdItem = 3
        val myArrayList = MyArrayList<Int>(1)
        with(myArrayList) {
            add(firstItem)
            add(secondItem)
            add(thirdItem)
        }
        val expectedToString = "[$firstItem, $secondItem, $thirdItem]"
        assertEquals(expectedToString, myArrayList.toString())
    }

    @Test
    @DisplayName("test selection sort")
    fun testSelectionSort(){
        val myArrayList = MyArrayList<Int>()
        with(myArrayList){
            add(5)
            add(4)
            add(16)
            add(8)
        }

        myArrayList.selectionSort()
        val expectedToString = "[4, 5, 8, 16]"
        assertEquals(expectedToString, myArrayList.toString())
    }

    @Test
    @DisplayName("test insertion sort")
    fun testInsertionSort(){
        val myArrayList = MyArrayList<Int>()
        with(myArrayList){
            add(5)
            add(4)
            add(16)
            add(8)
        }

        myArrayList.insertionSort()
        val expectedToString = "[4, 5, 8, 16]"
        assertEquals(expectedToString, myArrayList.toString())
    }

    @Test
    @DisplayName("test bubble sort")
    fun testBubbleSort(){
        val myArrayList = MyArrayList<Int>()
        with(myArrayList){
            add(5)
            add(4)
            add(16)
            add(8)
        }

        myArrayList.bubbleSort()
        val expectedToString = "[4, 5, 8, 16]"
        assertEquals(expectedToString, myArrayList.toString())
    }
}