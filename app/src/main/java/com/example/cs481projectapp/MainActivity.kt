package com.example.cs481projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calculator)

        val intent = Intent(this, CalculatorActivity::class.java);
        startActivity(intent);
    }
}