package com.example.cs481projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.cs481projectapp.cogfacilities.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val cogs = arrayOf("Bossbot", "Lawbot", "Cashbot", "Sellbot")
        val cogTypeSpinner = findViewById<Spinner>(R.id.cogTypeSpinner)
        cogTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cogs)
        // someone figure this stuff out:
    //        cogTypeSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, p3: Long) {
//                TODO("Not yet implemented")
//            }
//        }

        val numPointsNeeded = findViewById<EditText>(R.id.numPointsNeededInput)
        val numPointsObtained = findViewById<EditText>(R.id.numPointsObtainedInput)
        var pointsCalculated = findViewById<TextView>(R.id.statsCalculatedOutput)
        var calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {

            TODO("get cogTypeSpinner selection")
            //pointsCalcuated = findCogCalculation(cogTypeSpinnerSelection, numPointsNeeded, numPointsObtained)
            //output pointsCalculated (????)
        }

        fun findCogSuit(cog: String, needed: Int, obtained: Int): String{

            var icogfacility: ICogFacility
            when(cog){
                "Bossbot" -> icogfacility = BossbotGolfCourse()
                "Lawbot" -> icogfacility = LawbotDAOffice()
                "Cashbot" -> icogfacility = CashbotMint()
                "Sellbot" -> icogfacility = SellbotFactory()
                else -> {
                    icogfacility = SellbotFactory() //hacky fix for icogfacility initialization on return line
                    println("Error: invalid choice; ending program")
                    System.exit(0)
                }
            }
            return icogfacility.calculateStats(obtained, needed)
        }
    }

}