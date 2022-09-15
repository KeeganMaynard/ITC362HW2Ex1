package com.keegan.android.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    private var tipCalc = TipCalculator()
    val money:NumberFormat = NumberFormat.getCurrencyInstance()
    private lateinit var billEditText : EditText
    private lateinit var tipEditText: EditText
    private lateinit var calcButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tipCalc = TipCalculator(.17f, 100.0f)
        setContentView(R.layout.activity_main)

        billEditText = findViewById(R.id.amount_bill)
        tipEditText = findViewById(R.id.amount_tip_percent)
        calcButton = findViewById(R.id.calculate_button)

        calcButton.setOnClickListener {
            calculate()
        }
    }

    fun calculate(){
        var billString = billEditText.text.toString()
        var tipString = tipEditText.text.toString()

        var tipText = findViewById<TextView>(R.id.amount_tip)
        var totalText = findViewById<TextView>(R.id.amount_total)
        try {
            var billAmount = billString.toFloat()
            var tipPercent = tipString.toInt()

            tipCalc.bill = billAmount
            tipCalc.tip = .01f * tipPercent

            var tip = tipCalc.tipAmount()
            var total = tipCalc.totalAmount()

            tipText.setText(money.format(tip))
            totalText.setText(money.format(total))
        } catch (nfe:NumberFormatException){
            //Pop up an alert view here
        }
    }
}