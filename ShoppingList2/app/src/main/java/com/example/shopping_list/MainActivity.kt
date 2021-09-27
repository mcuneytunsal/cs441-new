package com.example.shopping_list

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter: ArrayAdapter<*>
        val groceries = mutableListOf<String>(
            "Lettuce",
            "Cucumber",
            "Garlic"
        )

        //adds input to the list and shows on screen
        fun addGrocery(){
            val newGrocery=findViewById<EditText>(R.id.editText).text.toString()
            groceries.add(newGrocery)
        }

         fun clickButton() {
             addGrocery()
         }

        val execute: Button = findViewById(R.id.button2)
        execute.setOnClickListener { clickButton() }

        // accessing listView
        val listView = findViewById<ListView>(R.id.listView)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, groceries)
        listView.adapter = arrayAdapter
    }


}