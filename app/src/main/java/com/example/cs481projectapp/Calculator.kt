package com.example.cs481projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.cs481projectapp.cogfacilities.*
import kotlin.reflect.typeOf

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var cogTypeChosen: String = ""
        val cogs = arrayOf("Bossbot", "Lawbot", "Cashbot", "Sellbot")
        val cogTypeSpinner = findViewById<Spinner>(R.id.cogTypeSpinner)

        cogTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cogs)

        cogTypeSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (view != null) {
                    //Toast.makeText(view.context, cogTypeSpinner.selectedItem , Toast.LENGTH_LONG).show()
                    cogTypeChosen = cogTypeSpinner.selectedItem.toString()
                };
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val numPointsObtained = findViewById<EditText>(R.id.numPointsObtainedInput).toString()
        val numPointsNeeded = findViewById<EditText>(R.id.numPointsNeededInput).toString()
        var pointsCalculated = findViewById<TextView>(R.id.statsCalculatedOutput)
        var calculateButton = findViewById<Button>(R.id.calculateButton)


        fun findCogSuit(cog: String, needed: Int, obtained: Int): String{
            TODO("Figure out how to make this work")
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

        calculateButton.setOnClickListener {

            var obtained = Integer.parseInt(numPointsObtained)
            var needed = Integer.parseInt(numPointsNeeded)
//            pointsCalculated.text = findCogSuit(cogTypeChosen, needed, obtained)
        }
    }

}