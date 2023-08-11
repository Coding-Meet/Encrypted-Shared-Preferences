package com.coding.meet.encryptedsharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edName = findViewById<EditText>(R.id.edName)
        val edAge = findViewById<EditText>(R.id.edAge)
        val btnSet = findViewById<Button>(R.id.btnSet)
        val btnGet = findViewById<Button>(R.id.btnGet)
        val btnClear = findViewById<Button>(R.id.btnClear)


        val encryptSharedPreferenceManager = EncryptSharedPreferenceManager(this)

        btnClear.setOnClickListener {
            edName.text = null
            edAge.text = null
        }

        btnSet.setOnClickListener {
            encryptSharedPreferenceManager.name = edName.text.toString()
            encryptSharedPreferenceManager.age = edAge.text.toString().toInt()
        }

        btnGet.setOnClickListener {
            edName.setText(encryptSharedPreferenceManager.name )
            edAge.setText(encryptSharedPreferenceManager.age.toString() )
        }


    }
}