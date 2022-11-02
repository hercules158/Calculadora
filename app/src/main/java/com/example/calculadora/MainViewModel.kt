package com.example.calculadora

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class MainViewModel : ViewModel() {

    val number = MutableLiveData("")
    var result = MutableLiveData("")

    /*
    O algoritmo de adicionar um número e remover separa a string em duas partes, a primeira metade
    e a segunda metade a partir da posição em que o cursor está localizado, então dígito é adicionado
    ou removido ao final da primeira parte da string
    * */

    fun assemblyNum(digit: String, cursorPosition: Int) {
        val macrosPosition = cursorPosition
        if (digit != "<" && digit != "~") {
            var firstHalf = number.value?.dropLast(number.value!!.length.minus(macrosPosition))
            val secondHalf = number.value?.drop(macrosPosition)
            firstHalf += digit
            number.value = firstHalf + secondHalf
        } else if (macrosPosition == 0 && digit != "~" && digit != "<") {
            number.value += digit
        }
        try {
            if ((digit == "<" && number.value != "")) { //To erase a digit
                var firstHalf = number.value?.dropLast(number.value!!.length.minus(cursorPosition))
                val secondHalf = number.value?.drop(cursorPosition)
                firstHalf = firstHalf?.dropLast(1)
                number.value = firstHalf + secondHalf
            }
        } catch (e: Exception) {
        }
        if (digit == "~") {
            number.value = ""
        }
        try {
            if (number.value!!.count { it == '(' } == number.value!!.count { it == ')' }) {
                val e = Expression(number.value.toString()) //Function from mxparse lib

                    result.value = e.calculate().toString()

                if (result.value == "NaN") {
                    result.value = ""
                }
            }
        } catch (e: Exception) {
        }

        if (number.value == "") result.value = ""

    }

}



