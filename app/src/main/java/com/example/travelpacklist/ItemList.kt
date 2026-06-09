package com.example.travelpacklist

import android.content.Intent
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
        btnDisplay.setOnClickListener {
            //Error handling to check if the item array is empty
            if (items.isEmpty()) {
                txtList.text = "No items found"
                return@setOnClickListener
            }
            //variable for building the display string
            var display = "Items with two or more quantities:\n\n"

            //Variable to check if any qualifying items were found
            var found = false

            //Counter to loop through the arrays
            var i = 0

            //Looping through all items
            while (i < items.size) {
                //Displaying items where quantity is 2 or more
                if (quantities[i] >= 2) {
                    display += " ${items[i]} - Quantity: ${quantities[i]}\n\n"
                    found = true
                }
                //Moving to next item
                i++

            }
            // Error handling  with no items with 2 or more quantities found
            if (!found) {
                txtList.text = "No items with 2 or more quantities"
                return@setOnClickListener
            }
            //Displaying the final string in the text view
            txtList.text = display
        }

        //Button which takes you back to the main screen
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}