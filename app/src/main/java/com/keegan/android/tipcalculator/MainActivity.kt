package com.keegan.android.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    private var tipCalc = TipCalculator()
    val money = NumberFormat.getCurrencyInstance()
    private lateinit var billText : EditText
    private lateinit var tipText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tipCalc = TipCalculator(.17f, 100.0f)
        setContentView(R.layout.activity_main)

    }
}