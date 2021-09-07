package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /*
        * Show the title of Application -> Header
        * => This is the override function from `AppCompatActivity`
        *    If you delete this code, it will makes this application not working
        * */
        super.onCreate(savedInstanceState)

        /*
        * Show the contents of Application -> Body
        * => If you delete this code, it will makes this application not display
        *    the body part of it
        * */
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.heightEditText); // Variable allocation style
        val weightEditText = findViewById<EditText>(R.id.weightEditText); // Generic Style

        val resultButton: Button = findViewById(R.id.resultButton);
        resultButton.setOnClickListener{
            Log.d("MainActivity", "ResultButton 이 클릭되었습니다")

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                // If some values in the text are empty
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = heightEditText.text.toString().toInt();
            val weight: Int = weightEditText.text.toString().toInt();

            Log.d("MainActivity", "height : $height - weight : $weight")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        };
    }
}
