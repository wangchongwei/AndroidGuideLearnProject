package com.example.mvx.mvx.android.guide.learn.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvx.mvx.android.guide.learn.project.annotation.SecondActivity
import com.example.mvx.mvx.android.guide.learn.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("age", 31)
            intent.putExtra("sex", "male")
            intent.putExtra("married", true)
            startActivity(intent)
        }
    }
}