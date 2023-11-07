package com.handbook.fisherman

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        val tvTitle: TextView = findViewById(R.id.tv_Title_pr)
        val tvContent: TextView = findViewById(R.id.tv_content_pr)
        val iv: ImageView = findViewById(R.id.iv)
        tvTitle.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")
        iv.setImageResource(intent.getIntExtra("image", R.drawable.ic_fish))
    }
}