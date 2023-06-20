package com.first.notuygulamalari

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_not_kayit.*

class DetayActivity : AppCompatActivity() {
    private lateinit var not:Notlar
    private lateinit var zafer:VeriTabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        toolbar3.title="Not Detay"
        setSupportActionBar(toolbar3)
        zafer= VeriTabaniYardimcisi(this@DetayActivity)
        not=intent.getSerializableExtra("nesne") as Notlar

        editTextTextPersonName4.setText(not.not_ad)
        editTextTextPersonName5.setText((not.not1).toString())
        editTextTextPersonName6.setText((not.not2).toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.actionSil-> {
                Snackbar.make(toolbar3,"Silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet")
                    {
                        NotlarDao().notSil(zafer,not.not_id)


                        startActivity(Intent(this@DetayActivity, MainActivity::class.java))
                        finish()
                    }.show()
                return true
            }
            R.id.actionDuzenle-> {
                val not_ad=editTextTextPersonName4.text.toString().trim()
                val not1=editTextTextPersonName5.text.toString().trim()
                val not2=editTextTextPersonName6.text.toString().trim()
                if (TextUtils.isEmpty(not_ad)){
                    Snackbar.make(toolbar3,"Ders Adı Griniz",Snackbar.LENGTH_LONG).show()
                    return false
                }
                if (TextUtils.isEmpty(not1)){
                    Snackbar.make(toolbar3,"1.Notu Giriniz",Snackbar.LENGTH_LONG).show()
                    return false
                }
                if (TextUtils.isEmpty(not2)){
                    Snackbar.make(toolbar3,"2.Notu Giriniz",Snackbar.LENGTH_LONG).show()
                    return false
                }



                NotlarDao().notGuncelle(zafer,not.not_id,not_ad,not1.toInt(), not2.toInt())

                startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                finish()
                return true
            }
            else->return false
        }
    }
}