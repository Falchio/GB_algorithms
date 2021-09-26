package lesson3

import org.junit.jupiter.api.*

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class MyDequeueTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    @DisplayName("input capacity is less than zero")
    fun testCapacityUntilNull(){
        assertFailsWith<IllegalArgumentException> { MyDeque<Int>(-1) }
    }

   @Test
   fun `add one element -- remove her from left` () {
       val myDeque = MyDeque<Int>(5)
       myDeque.insertFirst(1)
       val expectedInt = 1
       val removedInt = myDeque.removeFirst()
       assertEquals(expectedInt,removedInt)
   }

    @Test
    fun `add one element -- remove her from right` () {
        val myDeque = MyDeque<Int>(5)
        myDeque.insertLast(1)
        val expectedInt = 1
        val removedInt = myDeque.removeLast()
        assertEquals(expectedInt,removedInt)
    }

    @Test
    fun `add two element -- remove last`(){
        val myDequeque = MyDeque<Int>(5)
        myDequeque.insertFirst(1)
        myDequeque.insertFirst(2)
        val expected = 1
        val actual = myDequeque.removeLast()
        assertEquals(expected, actual)
    }

    @Test
    fun `add two elements -- remove first`(){
        val myDeque = MyDeque<Int>(5)
        myDeque.insertFirst(1)
        myDeque.insertFirst(2)
        val expected = 2
        val actual = myDeque.removeFirst()
        assertEquals(expected, actual)
    }


}