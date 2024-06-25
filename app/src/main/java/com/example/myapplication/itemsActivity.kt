package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class itemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

    items.add(Item(1, "mercedece200", "Mercedes Е200", "Мереседес е200","Полный привод, седан, АКП, период выпуска 2020-2022, связь WhatsApp", 3000,"+79612963656"))
             items.add(Item(3, "lexus70", "Lexus 70", "Лексус 70","Полный привод, седан, АКП, период выпуска 2020-2021", 2500,"+987654321"))
        items.add(Item(1, "bmwm5f90", "BMW M5 F90", "Бмв м5 f90","Полный привод, седан, АКП, период выпуска 2018-2022,", 3500, "+123456789"))

val layoutManager = LinearLayoutManager(this)
        itemsList.layoutManager = layoutManager

//        val dividerItemDecoration = DividerItemDecoration(
//            itemsList.getContext(),
//          layoutManager.getOrientation()
//        )
//        itemsList.addItemDecoration(dividerItemDecoration)

        itemsList.adapter = ItemsAdapter(items, this)


    }
}