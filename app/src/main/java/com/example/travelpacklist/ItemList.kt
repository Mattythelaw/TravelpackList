package com.example.travelpacklist

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item_list)

        //Linking the XML views to ItemList.kt
        val txtList = findViewById<TextView>(R.id.txtList)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnBack = findViewById<Button>(R.id.btnBack)

        //Receiving the arrays passed from Main Activity
        val items = intent.getStringArrayExtra("items") ?: emptyArray()
        val quantities = intent.getIntArrayExtra("quantities") ?: intArrayOf()

        //Displaying packing list button which runs when user clicks button

            //Error Handling to check if items in array are missing



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}