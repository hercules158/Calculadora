package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            viewModel.assemblyNum("0")
        }
        binding.button1.setOnClickListener{
            viewModel.assemblyNum("1")
        }
        binding.button2.setOnClickListener{
            viewModel.assemblyNum("2")
        }
        binding.button3.setOnClickListener{
            viewModel.assemblyNum("3")
        }
        binding.button4.setOnClickListener{
            viewModel.assemblyNum("4")
        }
        binding.button5.setOnClickListener{
            viewModel.assemblyNum("5")
        }
        binding.button6.setOnClickListener{
            viewModel.assemblyNum("6")
        }
        binding.button7.setOnClickListener{
            viewModel.assemblyNum("7")
        }
        binding.button8.setOnClickListener{
            viewModel.assemblyNum("8")
        }
        binding.button9.setOnClickListener{
            viewModel.assemblyNum("9")
        }
        binding.buttonAddition.setOnClickListener{
            viewModel.assemblyNum("+")
        }
        binding.buttonSubtraction.setOnClickListener{
            viewModel.assemblyNum("-")
        }
        binding.buttonTimes.setOnClickListener{
            viewModel.assemblyNum("*")
        }
        binding.buttonDivision.setOnClickListener{
            viewModel.assemblyNum("/")
        }
        binding.iconUndo.setOnClickListener{
            viewModel.assemblyNum("<")
        }
        binding.iconUndo.setOnLongClickListener {
            viewModel.assemblyNum("~")
            true
        }
        binding.buttonLeftBracket.setOnClickListener{
            viewModel.assemblyNum("(")
        }
        binding.buttonRightBracket.setOnClickListener{
            viewModel.assemblyNum(")")
        }
        setObserver()
    }
    private fun setObserver() {
        viewModel.number.observe(this ) {
            binding.textWrite.text = it

        }
        viewModel.result.observe(this) {
            binding.textResult.text = it.toString()
        }
    }

}

