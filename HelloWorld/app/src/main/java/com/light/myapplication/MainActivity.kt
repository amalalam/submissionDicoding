package com.light.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var longs: TextView
    private lateinit var width: TextView
    private lateinit var height: TextView
    private lateinit var btnResult: Button
    private lateinit var result : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        longs = findViewById(R.id.insertLong)
        width = findViewById(R.id.insertWidth)
        height = findViewById(R.id.insertHeight)
        btnResult = findViewById(R.id.btnResult)
        result = findViewById(R.id.result)

        btnResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val inputLongs = longs.text.toString()
        val inputWidth = width.text.toString()
        val inputHeight = height.text.toString()

        val volume = inputLongs.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
        result.setText(volume.toString())
    }

}
