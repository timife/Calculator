package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate created")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.calculator_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return click events
        return when(item.itemId){
            R.id.mnu_Calk -> {
                item.isChecked = true
                val viewModel: CalculatorViewModel by viewModels()

                viewModel.stringResult.observe(
                    this,
                    Observer<String> { stringResult -> result.setText(stringResult) })
                viewModel.stringNewNumber.observe(
                    this,
                    Observer<String> { stringNumber -> newNumber.setText(stringNumber) })  //setText: It's editable.
                viewModel.stringOperation.observe(
                    this,
                    Observer<String> { stringOperation ->
                        operation.text = stringOperation
                    }) //the lambda is to provide the callbacks that will be executed when the observed object changes.
                //set clicklistener for the digits
                val listener = View.OnClickListener { v ->
                    //            val b = v as Button
//            newNumber.append(b.text)
                    viewModel.digitPressed((v as Button).text.toString())
                }
                button0.setOnClickListener(listener)
                button1.setOnClickListener(listener)
                button2.setOnClickListener(listener)
                button3.setOnClickListener(listener)
                button4.setOnClickListener(listener)
                button5.setOnClickListener(listener)
                button6.setOnClickListener(listener)
                button7.setOnClickListener(listener)
                button8.setOnClickListener(listener)
                button9.setOnClickListener(listener)
                buttonDot.setOnClickListener(listener)

                //set clicklistener for the operation keys
                val opListener = View.OnClickListener { v ->
                    viewModel.operandPressed((v as Button).text.toString())

                }
                buttonEquals.setOnClickListener(opListener)
                buttonDivide.setOnClickListener(opListener)
                buttonMultiply.setOnClickListener(opListener)
                buttonMinus.setOnClickListener(opListener)
                buttonPlus.setOnClickListener(opListener)

                buttonNeg.setOnClickListener {
                    viewModel.negPressed()

                }
                Toast.makeText(this,"Calculator!!",Toast.LENGTH_LONG).show()
                true
            }
            R.id.mnu_BigDecimal -> {
                item.isChecked = true

                    val viewModel: BigDecimalViewModel by viewModels()

                    viewModel.stringResult.observe(
                        this,
                        Observer<String> { stringResult -> result.setText(stringResult) })
                    viewModel.stringNewNumber.observe(
                        this,
                        Observer<String> { stringNumber -> newNumber.setText(stringNumber) })  //setText: It's editable.
                    viewModel.stringOperation.observe(
                        this,
                        Observer<String> { stringOperation ->
                            operation.text = stringOperation
                        }) //the lambda is to provide the callbacks that will be executed when the observed object changes.
                    //set clicklistener for the digits
                    val listener = View.OnClickListener { v ->
                        //            val b = v as Button
//            newNumber.append(b.text)
                        viewModel.digitPressed((v as Button).text.toString())
                    }
                    button0.setOnClickListener(listener)
                    button1.setOnClickListener(listener)
                    button2.setOnClickListener(listener)
                    button3.setOnClickListener(listener)
                    button4.setOnClickListener(listener)
                    button5.setOnClickListener(listener)
                    button6.setOnClickListener(listener)
                    button7.setOnClickListener(listener)
                    button8.setOnClickListener(listener)
                    button9.setOnClickListener(listener)
                    buttonDot.setOnClickListener(listener)

                    //set clicklistener for the operation keys
                    val opListener = View.OnClickListener { v ->
                        viewModel.operandPressed((v as Button).text.toString())

                    }
                    buttonEquals.setOnClickListener(opListener)
                    buttonDivide.setOnClickListener(opListener)
                    buttonMultiply.setOnClickListener(opListener)
                    buttonMinus.setOnClickListener(opListener)
                    buttonPlus.setOnClickListener(opListener)

                    buttonNeg.setOnClickListener {
                        viewModel.negPressed()

                    }
                    Toast.makeText(this,"Accountant's Calculator!!",Toast.LENGTH_LONG).show()
                    true

            }
            else -> {
                item.isChecked = false
                super.onOptionsItemSelected(item)
            }


        }

    }
}
