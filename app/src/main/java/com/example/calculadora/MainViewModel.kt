package com.example.calculadora

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.notkamui.keval.Keval
import kotlin.math.pow


class MainViewModel : ViewModel() {

    val number = MutableLiveData("")
    var result = MutableLiveData(0f)

    fun assemblyNum(digit: String) {

        number.value += digit

        if ((digit == "<" && number.value != "")) {
            number.value = number.value!!.dropLast(2)
        } else if (digit == "~") {
            number.value = ""
        }

        try {
            if (number.value!!.count { it == '(' } == number.value!!.count { it == ')' }) {
                result.value = Keval.eval(number.value.toString()).toFloat() //Função adicionada com a biblioteca
            }
        } catch (e: Exception) {
            null
        }

        if (number.value == "") result.value = 0f

    }

}

