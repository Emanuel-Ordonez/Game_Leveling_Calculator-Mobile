package com.example.cs481projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.cs481projectapp.cogfacilities.*
import kotlin.reflect.typeOf

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var cogTypeChosen: String = ""
        val cogs = arrayOf("Bossbot", "Lawbot", "Cashbot", "Sellbot")
        val cogTypeSpinner = findViewById<Spinner>(R.id.cogTypeSpinner)

        //cogTypeSpinner stuff keeps breaking everything. SOS!
        cogTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cogs)
        cogTypeSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (view != null) {
                    Toast.makeText(view.context, cogTypeSpinner.selectedItemPosition, Toast.LENGTH_LONG).show()
                    cogTypeChosen = cogTypeSpinner.selectedItem.toString()
                };
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val numPointsObtained = findViewById<EditText>(R.id.numPointsObtainedInput).toString()
        val numPointsNeeded = findViewById<EditText>(R.id.numPointsNeededInput).toString()
        val pointsCalculated = findViewById<TextView>(R.id.statsCalculatedOutput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val obtained = Integer.parseInt(numPointsObtained)
            val needed = Integer.parseInt(numPointsNeeded)
            pointsCalculated.text = findCogSuit(cogTypeChosen, needed, obtained)
        }
    }

    public fun findCogSuit(cog: String, needed: Int, obtained: Int): String{
        val icogfacility: ICogFacility
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