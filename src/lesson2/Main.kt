package lesson2

import java.util.concurrent.TimeUnit
import kotlin.random.Random

fun main() {
    val arraySize = 100_000
    val myArrayList = MyArrayList<Int>(arraySize)
    val random = Random(arraySize)

    var time:Long

    for (i in 0 until arraySize) {
        myArrayList.add(random.nextInt(arraySize))
    }


    var selectionArray = myArrayList.clone()
    time = System.currentTimeMillis()
    selectionArray.selectionSort()
    println("Сортировка выбором для массива размером:$arraySize завершилась за ${getDuration(time)} секунд")

    var bubbleArray = myArrayList.clone()
    time = System.currentTimeMillis()
    bubbleArray.bubbleSort()
    println("Пузырьковая сортировка для массива размером:$arraySize завершилась за ${getDuration(time)} секунд")

    var insertionArray = myArrayList.clone()
    time = System.currentTimeMillis()
    insertionArray.insertionSort()
    println("Сортировка вставкой для массива размером:$arraySize завершилась за ${getDuration(time)} секунд")

    myArrayList.selectionSort()

    selectionArray = myArrayList.clone()
    time = System.currentTimeMillis()
    selectionArray.selectionSort()
    println("Подан уже отсортированный массив! Сортировка выбором для массива размером:$arraySize завершилась за ${getDuration(time)} секунд")

    bubbleArray = myArrayList.clone()
    time = System.currentTimeMillis()
    bubbleArray.bubbleSort()
    println("Подан уже отсортированный массив! Пузырьковая сортировка для массива размером:$arraySize завершилась за ${getDuration(time)} секунд")

    insertionArray = myArrayList.clone()
    time = System.currentTimeMillis()
    insertionArray.insertionSort()
    println("Подан уже отсортированный массив! Сортировка вставкой для массива размером:$arraySize завершилась за ${getDuration(time)} секунд")

}

private fun getDuration(time: Long) = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - time)