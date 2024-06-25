package com.example.myapplication

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)


        val title: TextView = findViewById(R.id.item_list_title_one)
        val text : TextView = findViewById(R.id.item_list_text)
        val imageView: ImageView = findViewById(R.id.item_list_image)
        val itemImage = intent.getStringExtra("itemImage")
        val phone: TextView = findViewById(R.id.item_list_phone)
        val itemPhone = intent.getStringExtra("itemPhone")

        phone.text = itemPhone



        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        val imageId = resources.getIdentifier(itemImage, "drawable", packageName)
        imageView.setImageResource(imageId)

        phone.setOnClickListener {
            val uri = Uri.parse("https://wa.me/$itemPhone")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        

    }
}