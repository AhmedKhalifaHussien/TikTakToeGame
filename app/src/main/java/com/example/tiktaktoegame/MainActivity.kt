package com.example.tiktaktoegame

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.icu.util.TimeUnit
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.tiktaktoegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val list=Array(9){0}
    private var totalSelected=0
    private var allSelected=Array(3){IntArray(3)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        set()
        val getPlayerOneName=intent.getStringExtra(Players.Constants.PLAYER_ONE)
        val getPlayerTwoName=intent.getStringExtra(Players.Constants.PLAYER_TWO)

        binding.TextViewPlayerOne.text=getPlayerOneName
        binding.TextViewPlayerTwo.text=getPlayerTwoName


        binding.image1.setOnClickListener {
            if(list[0]==0){
                list[0]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image1.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[0][0]=1

                }
                else{
                    binding.image1.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[0][0]=0

                }

            }
            checkWinner()
        }
        binding.image2.setOnClickListener {
            if(list[1]==0){
                list[1]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image2.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[0][1]=1
                }
                else{
                    binding.image2.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[0][1]=0
                }

            }
            checkWinner()
        }
        binding.image3.setOnClickListener {
            if(list[2]==0){
                list[2]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image3.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[0][2]=1
                }
                else{
                    binding.image3.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[0][2]=0
                }
            }
            checkWinner()
        }
        binding.image4.setOnClickListener {
            if(list[3]==0){
                list[3]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image4.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[1][0]=1
                }
                else{
                    binding.image4.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[1][0]=0
                }
            }
            checkWinner()
        }
        binding.image5.setOnClickListener {
            if(list[4]==0){
                list[4]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image5.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[1][1]=1
                }
                else{
                    binding.image5.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[1][1]=0
                }
            }
            checkWinner()
        }
        binding.image6.setOnClickListener {
            if(list[5]==0){
                list[5]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image6.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[1][2]=1
                }
                else{
                    binding.image6.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[1][2]=0
                }
            }
            checkWinner()
        }
        binding.image7.setOnClickListener {
            if(list[6]==0){
                list[6]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image7.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[2][0]=1
                }
                else{
                    binding.image7.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[2][0]=0
                }
            }
            checkWinner()
        }
        binding.image8.setOnClickListener {
            if(list[7]==0){
                list[7]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image8.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[2][1]=1
                }
                else{
                    binding.image8.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[2][1]=0
                }
            }
            checkWinner()
        }
        binding.image9.setOnClickListener {
            if(list[8]==0){
                list[8]=1
                totalSelected++
                if(totalSelected%2!=0){
                    binding.image9.setImageResource(R.drawable.ic_x)
                    changePlayerX()
                    allSelected[2][2]=1
                }
                else{
                    binding.image9.setImageResource(R.drawable.ic_o)
                    changePlayerO()
                    allSelected[2][2]=0
                }
            }
            checkWinner()
        }


    }
    private fun changePlayerX(){
        binding.PlayerOneLayout.setBackgroundDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.player_not_selected))
        binding.PlayerTwoLayout.setBackgroundDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.player_selected))
    }
    private fun changePlayerO(){
        binding.PlayerOneLayout.setBackgroundDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.player_selected))
        binding.PlayerTwoLayout.setBackgroundDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.player_not_selected))

    }
    private fun set(){
        for(i in 0..2){
            for(j in 0..2) {
                allSelected[i][j]=2
            }
        }
    }
    private fun stop(){
        //java.util.concurrent.TimeUnit.SECONDS.sleep(1)
    }
    private fun reset(){

       // java.util.concurrent.TimeUnit.SECONDS.sleep(3)
        binding.image1.setImageResource(R.drawable.xo_no_border)
        binding.image2.setImageResource(R.drawable.xo_no_border)
        binding.image3.setImageResource(R.drawable.xo_no_border)
        binding.image4.setImageResource(R.drawable.xo_no_border)
        binding.image5.setImageResource(R.drawable.xo_no_border)
        binding.image6.setImageResource(R.drawable.xo_no_border)
        binding.image7.setImageResource(R.drawable.xo_no_border)
        binding.image8.setImageResource(R.drawable.xo_no_border)
        binding.image9.setImageResource(R.drawable.xo_no_border)
        for(i in 0..8){
            list[i]=0
        }
        for(i in 0..2){
            for(j in 0..2)
                allSelected[i][j]=0
        }
        totalSelected=0
        Log.i("aa","total = $totalSelected")
        set()
        changePlayerO()
    }

    private fun checkWinner(){

        //Tie
        if(totalSelected==9){
            Toast.makeText(applicationContext,"Tie",Toast.LENGTH_SHORT).show()
            reset()
        }

        //row by row
        for(i in 0..2){
            var cntOnes=0
            var cntZeros=0
            for(j in 0..2){
                if(allSelected[i][j]==0){
                    cntZeros++
                }
                if(allSelected[i][j]==1){
                    cntOnes++
                }
            }
            if(cntOnes==3){
                Toast.makeText(applicationContext,"${binding.TextViewPlayerOne.text} Win",Toast.LENGTH_SHORT).show()
                var scoreOne = binding.TextViewScorePlayerOne.text.toString().toInt()
                scoreOne++
                binding.TextViewScorePlayerOne.text=scoreOne.toString()
                reset()
            }
            if(cntZeros==3){
                Toast.makeText(applicationContext,"${binding.TextViewPlayerTwo.text} Win",Toast.LENGTH_SHORT).show()
                var scoreTwo = binding.TextViewScorePlayerTwo.text.toString().toInt()
                scoreTwo++
                binding.TextViewScorePlayerTwo.text=scoreTwo.toString()
                reset()

            }
        }
        // col by col
        for(j in 0..2){
            var cntOnes=0
            var cntZeros=0
            for(i in 0..2){
                if(allSelected[i][j]==0){
                    cntZeros++
                }
                if(allSelected[i][j]==1){
                    cntOnes++
                }
            }
            if(cntOnes==3){
                Toast.makeText(applicationContext,"${binding.TextViewPlayerOne.text} Win",Toast.LENGTH_SHORT).show()
                var scoreOne = binding.TextViewScorePlayerOne.text.toString().toInt()
                scoreOne++
                binding.TextViewScorePlayerOne.text=scoreOne.toString()
                reset()
            }
            if(cntZeros==3){
                Toast.makeText(applicationContext,"${binding.TextViewPlayerTwo.text} Win",Toast.LENGTH_SHORT).show()
                var scoreTwo = binding.TextViewScorePlayerTwo.text.toString().toInt()
                scoreTwo++
                binding.TextViewScorePlayerTwo.text=scoreTwo.toString()
                reset()
            }
        }
        // diagonal

        var cntOnes=0
        var cntZeros=0
        for(i in 0..2){
            for(j in 0..2) {
                if (i == j) {
                    if (allSelected[i][j] == 0)
                        cntZeros++
                    if (allSelected[i][j] == 1)
                        cntOnes++
                }
            }
        }
        if(cntOnes==3){
            Toast.makeText(applicationContext,"${binding.TextViewPlayerOne.text} Win",Toast.LENGTH_SHORT).show()
            var scoreOne = binding.TextViewScorePlayerOne.text.toString().toInt()
            scoreOne++
            binding.TextViewScorePlayerOne.text=scoreOne.toString()
            reset()
        }

        if(cntZeros==3){
            Toast.makeText(applicationContext,"${binding.TextViewPlayerTwo.text} Win",Toast.LENGTH_SHORT).show()
            var scoreTwo = binding.TextViewScorePlayerTwo.text.toString().toInt()
            scoreTwo++
            binding.TextViewScorePlayerTwo.text=scoreTwo.toString()
            reset()
        }
        cntOnes=0
        cntZeros=0
        for(i in 0..2){
            for(j in 0..2) {
                if (i+j==2) {
                    if (allSelected[i][j] == 0)
                        cntZeros++
                    if (allSelected[i][j] == 1)
                        cntOnes++
                }
            }
        }
        if(cntOnes==3){
            Toast.makeText(applicationContext,"${binding.TextViewPlayerOne.text} Win",Toast.LENGTH_SHORT).show()
            var scoreOne = binding.TextViewScorePlayerOne.text.toString().toInt()
            scoreOne++
            binding.TextViewScorePlayerOne.text=scoreOne.toString()
            reset()
        }
        if(cntZeros==3){
            Toast.makeText(applicationContext,"${binding.TextViewPlayerTwo.text} Win",Toast.LENGTH_SHORT).show()
            var scoreTwo = binding.TextViewScorePlayerTwo.text.toString().toInt()
            scoreTwo++
            binding.TextViewScorePlayerTwo.text=scoreTwo.toString()
            reset()
        }
    }

}