package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // using the arrayadapter for defining array
        val arrayAdapter: ArrayAdapter<*>
        val groceries = arrayOf(
            " Apple", "Orange", "Banana",
            "Lettuce", "Grape", "Olive"
        )

        //relativeLayout access
        var newRelativeLayout = findViewById<RelativeLayout>(R.id.relativeLayout)


        // listView access
        var newListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, groceries)
        newListView.adapter = arrayAdapter
    }
}