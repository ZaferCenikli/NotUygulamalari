package com.first.notuygulamalari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var notlarListe:ArrayList<Notlar>
    lateinit var adapter:NotlarAdapter
    lateinit var vt:VeriTabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title="Not Uygulaması"
        setSupportActionBar(toolbar)
        /*notlarListe= ArrayList()

         val n1=Notlar(1,"Tarih",50,60)
         val n2=Notlar(2,"Din",50,60)
         val n3=Notlar(3,"Türkçe",50,60)

         notlarListe.add(n1)
         notlarListe.add(n2)
         notlarListe.add(n3)*/
        vt=VeriTabaniYardimcisi(this@MainActivity)
        notlarListe=NotlarDao().tumNotlar(vt)
        adapter= NotlarAdapter(this,notlarListe)


        rv.adapter=adapter
        var toplam=0
        for (n in notlarListe){
            toplam=toplam+(n.not1+n.not2)/2
        }
        if (toplam !=0){
            toolbar.subtitle="Not ortalaması :${toplam/notlarListe.size}"

        }
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