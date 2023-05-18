package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageMainLogo)
        val textView = findViewById<TextView>(R.id.textView)
        val getStartBTN = findViewById<Button>(R.id.getStartedBTN)

        image.translationY = -1500f
        textView.translationY = 1000f
        getStartBTN.translationY = 1000f
        image.animate().apply {
            duration = 1500
            translationY(0f)
            duration = 1000
        }.withEndAction {
            image.animate().apply {
                duration = 2000
                translationY(-300f)
            }
        }
        textView.animate().apply {
            duration = 1500
            translationY(0f)
            duration = 1000
        }.withEndAction {
            textView.animate().apply {
                duration = 2000
                translationY(-360f)
            }
        }
        // Handler(Looper.getMainLooper()).postDelayed({#Define the intent for next activity here},2000) ->In case we want this to become SPLASH SCREEN.It'll be gone to next screen.
        getStartBTN.animate().apply {
            duration = 3000
            translationY(-300f)
        }.withEndAction {
            getStartBTN.animate().apply {
                duration = 800
                scaleX(1.7f)
                scaleY(1.7f)
            }
        }
        getStartBTN.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
            finish()
        }
    }
}