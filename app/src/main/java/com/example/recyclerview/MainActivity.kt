package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.MainActivityBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: MainActivityBinding
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var adapter: ItemAdapter
    lateinit var dbItem: DBItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        binding.rcView.layoutManager = gridLayoutManager
        binding.rcView.setHasFixedSize(true)
        dbItem = DBItem()

//        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
//        rcView.adapter=adapter
//

        adapter = ItemAdapter(applicationContext, dbItem.getData())
        binding.rcView.adapter = adapter
        setContentView(binding.root)

//        adapter.submitList(dbItem.getData())
    }

}