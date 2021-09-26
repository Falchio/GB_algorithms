package lesson5

import kotlin.math.pow

fun main(){
    val number:Double = 3.0
    val exponent:Double = 3.0
    println("Результат стандартной функции: ${number.pow(exponent)} \nРезультат рекурсивной функции: ${recursivePow(number,exponent)}")

}

fun recursivePow(number: Double, exponent: Double): Double {
    if (exponent == 1.0) return number
    return number * recursivePow(number, exponent - 1)
}