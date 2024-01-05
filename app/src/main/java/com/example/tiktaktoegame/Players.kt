package com.example.tiktaktoegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tiktaktoegame.databinding.ActivityPlayersBinding
import com.google.android.material.textfield.TextInputEditText

class Players : AppCompatActivity() {
    private lateinit var binding:ActivityPlayersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playerOneName=binding.EditTextPlayerOne.text
        val playerTwoName=binding.EditTextPlayerTwo.text

        binding.ButtonStartGame.setOnClickListener {
            if(check(playerOneName.toString(),playerTwoName.toString())){
                val intent=Intent(this,MainActivity::class.java)
                intent.putExtra(PLAYER_ONE,playerOneName.toString())
                intent.putExtra(PLAYER_TWO,playerTwoName.toString())
                startActivity(intent)
                binding.EditTextPlayerOne.text?.clear()
                binding.EditTextPlayerTwo.text?.clear()
            }else{
                Toast.makeText(applicationContext,"Please Enter Player Names",Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun check(playerName1:String,playerName2:String):Boolean{
        if(playerName1.isNotEmpty() && playerName2.isNotEmpty())
            return true
        return false
    }
    companion object Constants{
        const val PLAYER_ONE="player_one"
        const val PLAYER_TWO="player_two"
    }
}