package com.example.tictactoe

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun btnClick(view: View) {
        var cellID = 0
        val btnSelected = view as Button
        when (btnSelected.id) {
            R.id.row1btn1 -> cellID = 1
            R.id.row1btn2 -> cellID = 2
            R.id.row1btn3 -> cellID = 3
            R.id.row2btn1 -> cellID = 4
            R.id.row2btn2 -> cellID = 5
            R.id.row2btn3 -> cellID = 6
            R.id.row3btn1 -> cellID = 7
            R.id.row3btn2 -> cellID = 8
            R.id.row3btn3 -> cellID = 9
        }
        /*
        * Log.d("btnclick",btnSelected.id.toString())
        Log.d("btnclick cellID",cellID.toString())
        * */
        playGame(cellID, btnSelected)
    }

    private var activePlayer = 1
    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private fun playGame(cellID: Int, btnSelected: Button) {

        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.drawable.player1box)
            player1.add(cellID)
            activePlayer = 2
        } else {
            btnSelected.text = "0"
            btnSelected.setBackgroundResource(R.drawable.player2box)
            player2.add(cellID)
            activePlayer = 1
        }
        btnSelected.isSelected = false
        checkWinner()
    }

    @SuppressLint("SetTextI18n")
    fun checkWinner() {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner == 1) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialog)
            dialog.findViewById<TextView>(R.id.winnerName).text = "Player 1 win the game"
            dialog.findViewById<Button>(R.id.exitBTN).setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
            dialog.findViewById<Button>(R.id.playagainBTN).setOnClickListener {
                finish()
                startActivity(Intent(this, GameActivity::class.java))
            }
            dialog.show()
        } else if (winner == 2) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialog)
            dialog.findViewById<TextView>(R.id.winnerName).text = "Player 2 win the game"
            dialog.findViewById<Button>(R.id.exitBTN).setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
            dialog.findViewById<Button>(R.id.playagainBTN).setOnClickListener {
                finish()
                startActivity(Intent(this, GameActivity::class.java))
            }
            dialog.show()
        }

//        if(winner ==1){
//            Toast.makeText(this,"Player 1 Wins",Toast.LENGTH_SHORT).show()
//        }
//        else if(winner ==2){
//            Toast.makeText(this,"Player 2 Wins",Toast.LENGTH_SHORT).show()
//
//        }
    }
}