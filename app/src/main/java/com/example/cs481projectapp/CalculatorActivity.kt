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


        val cogs = arrayOf("Bossbot", "Lawbot", "Cashbot", "Sellbot")
        var cogTypeChosen: String= cogs[0]
        val cogTypeSpinner = findViewById<Spinner>(R.id.cogTypeSpinner)

        //cogTypeSpinner stuff keeps breaking everything. SOS!
        cogTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cogs)
        cogTypeSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (view != null) {
                    cogTypeChosen = cogTypeSpinner.selectedItem.toString()
                };
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val numPointsObtained = findViewById<EditText>(R.id.numPointsObtainedInput)
        val numPointsNeeded = findViewById<EditText>(R.id.numPointsNeededInput)
        val pointsCalculated = findViewById<TextView>(R.id.statsCalculatedOutput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val obtained = Integer.parseInt(numPointsObtained.text.toString())
            val needed = Integer.parseInt(numPointsNeeded.text.toString())
            //Toast.makeText(applicationContext, cogTypeChosen, Toast.LENGTH_LONG).show()
            pointsCalculated.text = findCogSuit(cogTypeChosen, obtained, needed)
        }
    }

    private fun findCogSuit(cog: String,  obtained: Int, needed: Int): String{
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