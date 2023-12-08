package com.example.gameslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameslist.databinding.ActivityDetailsGameBinding

class DetailsGame : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgGame: Int = intent.getIntExtra("imgGame",R.drawable.spider_man_jogo)
        val name: String? = intent.getStringExtra("name")
        val price: Double? = intent.getDoubleExtra("price",0.0)
        val description:String? = intent.getStringExtra("description")
        val platform:String? = intent.getStringExtra("plataforma")
        val store:String? = intent.getStringExtra("lojas")

        binding.imgGame.setBackgroundResource(imgGame)
        binding.namegame.text = "$name"
        binding.descriptionGame.text = "$description"
        binding.platformgame.text = "$platform"
        binding

        binding.backScreen.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

    }



}