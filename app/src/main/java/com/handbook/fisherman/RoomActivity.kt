package com.handbook.fisherman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.handbook.fisherman.databinding.RoomActivityBinding

class RoomActivity : AppCompatActivity() {
    lateinit var binding: RoomActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RoomActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDb(this)
        db.getDao().getAllItem().asLiveData().observe(this){ list->
            binding.tvList.text = ""
            list.forEach {
                val text = "Id: ${it.id} Name: ${it.name} Price: ${it.price}\n"
                binding.tvList.append(text)
            }
        }
        binding.button.setOnClickListener{
            val item = Item(null,
                binding.edName.text.toString(),
                binding.edPrice.text.toString()
                )
            Thread{
                db.getDao().insertItem(item)
            }.start()
        }
    }
}