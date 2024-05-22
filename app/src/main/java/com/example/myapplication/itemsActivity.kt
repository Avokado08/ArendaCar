package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class itemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "mercedes e200", "Mercedes Е200", "Мереседес е200","Полный привод, седан, АКП, период выпуска 2020-2022", 3000))
        items.add(Item(2, "bmwm5f90", "BMW M5 F90", "Бмв м5 f90","Полный привод, седан, АКП, период выпуска 2018-2022", 3500))
        items.add(Item(3, "Lexus 70", "Lexus 70", "Лексус 70","Полный привод, седан, АКП, период выпуска 2020-2021", 2500))
    }
}