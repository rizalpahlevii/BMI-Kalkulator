package com.example.bmikalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var weight : EditText
    private lateinit var height : EditText
    private lateinit var btnCalculate : Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById(R.id.edt_berat)
        height = findViewById(R.id.edt_tinggi)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate){
            val inputWeight = weight.text.toString().trim()
            val inputHeight = height.text.toString().trim()
            val strResult : String
            var emptyFields = false

            if(inputHeight.isEmpty()) {
                emptyFields = true
                height.error = "Tidak boleh kosong"
            }

            if(inputWeight.isEmpty()) {
                emptyFields = true
                weight.error = "Tidak boleh kosong"
            }

            if(!emptyFields){
                val bmi = inputWeight.toDouble() / ( inputHeight.toDouble() * inputHeight.toDouble() )
                val bmilevel = when {
                    bmi < 18.5 ->"Kekurangan Berat Badan"
                    bmi < 25 ->"Normal(Ideal)"
                    bmi < 30 ->"Kelebihan berat badan"
                    else -> "Kegemukan (Obesitas)"
                }
                strResult = "$bmi kg/m2 \n $bmilevel"
                tvResult.text = strResult
            }



        }
    }
}