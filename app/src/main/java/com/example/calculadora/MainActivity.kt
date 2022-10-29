package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.lifecycle.ViewModelProvider
import com.example.calculadora.databinding.ActivityMainBinding
import com.notkamui.keval.Keval

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        binding.button0.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd //Pego a posição do cursor no EditText
            viewModel.assemblyNum("0", cursorPosition) //Envio a posição do cursos para saber onde inserir uma nova string
            binding.textWrite.setSelection(cursorPosition+1) //Toda vez que digitar o local que irá inserir um novo número será na posição anterior do curso acrescido de 1
        }
        binding.button1.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("1", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button2.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("2", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button3.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("3", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button4.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("4", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button5.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("5", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button6.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("6", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button7.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("7", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button8.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("8", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.button9.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("9", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.buttonAddition.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("+", cursorPosition)
            binding.textWrite.setSelection(binding.textWrite.length())
        }
        binding.buttonSubtraction.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("-", cursorPosition)
            binding.textWrite.setSelection(binding.textWrite.length())
        }
        binding.buttonTimes.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("*", cursorPosition)
            binding.textWrite.setSelection(binding.textWrite.length())
        }
        binding.buttonDivision.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("/", cursorPosition)
            binding.textWrite.setSelection(binding.textWrite.length())
        }
        binding.iconUndo.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("<", cursorPosition)
            binding.textWrite.setSelection(cursorPosition-1)
        }
        binding.iconUndo.setOnLongClickListener {
            viewModel.assemblyNum("~", cursorPosition = 0)
            true
        }
        binding.buttonLeftBracket.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum("(", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        binding.buttonRightBracket.setOnClickListener{
            val cursorPosition = binding.textWrite.selectionEnd
            viewModel.assemblyNum(")", cursorPosition)
            binding.textWrite.setSelection(cursorPosition+1)
        }
        setObserver()
    }
    private fun setObserver() {
        viewModel.number.observe(this ) {
            binding.textWrite.text = Editable.Factory.getInstance().newEditable(it)
            binding.textWrite.showSoftInputOnFocus = false;

        }
        viewModel.result.observe(this) {
            binding.textResult.text = it.toString()
        }
    }

}

