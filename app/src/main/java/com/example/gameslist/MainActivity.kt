package com.example.gameslist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameslist.databinding.ActivityMain2Binding
import com.example.gameslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
         iniciar()
    }
     fun iniciar(){
         binding.btnEntrar.setOnClickListener {
             val intent = Intent(applicationContext,SecondActivity::class.java)
             startActivity(intent)
         }
     }

}