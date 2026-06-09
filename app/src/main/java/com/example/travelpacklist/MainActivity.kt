package com.example.travelpacklist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Declaring the four parallel arrays so it can be accessed in screen 2
    val items = arrayOf("T-shirts and pants", "Toothbrush", "Shoes", "Passport")
    val categories = arrayOf("Clothing", "Toiletries", "Clothing", "Documents")
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Linking the XML views from activity main to Main Activity
        val itemDetails = findViewById<TextView>(R.id.itemDetails)
        val packingBtn = findViewById<Button>(R.id.packingBtn)
        val btnItems = findViewById<Button>(R.id.btnItems)
        val exitBtn = findViewById<Button>(R.id.exitBtn)



        //The button listens for the user's clicks after that the user will be asked to enter
        //the details for the packing list
        packingBtn.setOnClickListener {
            itemDetails.text = "Please enter the details of the packing list"
        }

        btnItems.setOnClickListener {
            //It allows navigation to the ItemList screen (Screen 2)
            val intent = Intent(this, ItemList::class.java)
            startActivity(intent)

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}