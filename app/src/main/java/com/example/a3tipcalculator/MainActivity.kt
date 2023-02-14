package com.example.a3tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.selects.select

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculateTip()
    }
    fun calculateTip(){
        var cost : EditText = findViewById(R.id.etcost)
        var amount : TextView = findViewById(R.id.tvamount)
        var rg :RadioGroup = findViewById(R.id.rgroup)
        var roundUp : Switch = findViewById(R.id.switchROT)



        var btn : Button = findViewById(R.id.btntip)
        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                var selected : Int = rg.checkedRadioButtonId
                var tipPercentage : Double = when (selected){
                    R.id.rbamazing -> 0.20
                    R.id.rbgood -> 0.15
                    else -> 0.1
                }
                var tip = (cost.text.toString()).toDouble()*(tipPercentage.toString()).toDouble()
                var roundOfTip = roundUp.isChecked
                if (roundOfTip) {
                    tip = kotlin.math.ceil(tip)
                }
//                amount.text = ((cost.text.toString()).toDouble() * tipPercentage).toString()
                amount.text = tip.toString()
            }

        });
    }
}