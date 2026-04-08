package com.jesse.multiplaction

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // getting data from intent
        val tableString = intent.getStringExtra("tableNumber")
        
        // Use toIntOrNull to prevent crash if input is not a number
        val tableNumber = tableString?.toIntOrNull() ?: 0
        
        val tableDisplayText = findViewById<TextView>(R.id.tableDisplayText)
        var timesTxt = "$tableNumber x table\n\n"

        var counter = 1
        while (counter <= 20) {
            val answer = tableNumber * counter
            timesTxt += "$tableNumber x $counter = $answer\n"
            counter++
        }

        tableDisplayText.text = timesTxt
    }
}