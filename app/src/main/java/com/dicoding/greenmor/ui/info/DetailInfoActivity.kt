package com.dicoding.greenmor.ui.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.greenmor.R
import com.dicoding.greenmor.ui.control.Hero

class DetailInfoActivity : AppCompatActivity() {

    private lateinit var rvPopular: RecyclerView
    private val list = ArrayList<Info>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_info)

        supportActionBar!!.title = "Detail Info"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        rvPopular = findViewById(R.id.rv_popular)

        list.addAll(getListInfo())
        showRecyclerList()
    }


    private fun getListInfo(): ArrayList<Info> {
        val dataName = resources.getStringArray(R.array.data_info_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_info_photo)
        val listInfo = ArrayList<Info>()
        for (i in dataName.indices) {
            val hero = Info(dataName[i], dataPhoto.getResourceId(i, -1))
            listInfo.add(hero)
        }
        return listInfo
    }

    private fun showRecyclerList() {
        val listInfoAdapter = InfoAdapter(list, applicationContext)

        rvPopular.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.HORIZONTAL, false)
        rvPopular.adapter = listInfoAdapter
    }
}