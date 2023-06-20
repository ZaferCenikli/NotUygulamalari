package com.first.notuygulamalari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var notlarListe:ArrayList<Notlar>
    private lateinit var adapter:NotlarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Not Uygulaması"
        toolbar.subtitle="Not ortalaması : 60"
        setSupportActionBar(toolbar)

        notlarListe= ArrayList()

        val n1=Notlar(1,"Tarih",50,60)
        val n2=Notlar(2,"Din",50,60)
        val n3=Notlar(3,"Türkçe",50,60)

        notlarListe.add(n1)
        notlarListe.add(n2)
        notlarListe.add(n3)

        adapter= NotlarAdapter(this,notlarListe)
        rv.adapter=adapter





        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this@MainActivity)

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this@MainActivity,NotKayitActivity::class.java))



            
        }

    }

    override fun onBackPressed() {
        val intent=Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

    }
}