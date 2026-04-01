package com.jesse.multiplaction

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // assigning data from main to variable
        val bundle: Bundle? = intent.extras
        //getting the number enter by user as string
        val  tableString: String? = bundle?.getString("tableNumber")
        val tableNumber = tableString?.toInt()
        val tableDisplayText = findViewById<TextView>(R.id.tableDisplayText)


        setContentView(R.layout.activity_table_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}