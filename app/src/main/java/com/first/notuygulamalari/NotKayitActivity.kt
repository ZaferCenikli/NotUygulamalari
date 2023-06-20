package com.first.notuygulamalari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_not_kayit.*

class NotKayitActivity : AppCompatActivity() {
    private lateinit var vt:VeriTabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_kayit)

        vt= VeriTabaniYardimcisi(this@NotKayitActivity)
        button.setOnClickListener {

            val not_ad=editTextTextPersonName.text.toString().trim()
            val not1=editTextTextPersonName2.text.toString().trim()
            val not2=editTextTextPersonName3.text.toString().trim()
            if (TextUtils.isEmpty(not_ad)){
                Snackbar.make(toolbar2,"Ders Adı Griniz",Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not1)){
                Snackbar.make(toolbar2,"1.Notu Giriniz",Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not2)){
                Snackbar.make(toolbar2,"2.Notu Giriniz",Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            NotlarDao().notEkle(vt,not_ad,not1.toInt(),not2.toInt())
            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()

        }
    }
}