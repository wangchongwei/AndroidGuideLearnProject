package com.example.mvx.mvx.android.guide.learn.project.annotation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvx.mvx.android.guide.learn.project.R
import com.example.mvx.mvx.android.guide.learn.project.annotation.InjectData.inject
import com.example.mvx.mvx.android.guide.learn.project.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    @InjectIntent("age")
    private val age = 0

    @InjectIntent("married")
    private val married = false

    @InjectIntent("sex")
    private val sex: String? = null

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            inject(this)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        }
        initView()
    }

    private fun initView() {
        binding.text1.text = age.toString() + ""
        binding.text2.text = sex
        binding.text3.text = married.toString() + ""
    }
}