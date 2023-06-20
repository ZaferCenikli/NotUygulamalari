package com.first.notuygulamalari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        toolbar3.title="Not Detay"
        setSupportActionBar(toolbar3)
        val not=intent.getSerializableExtra("nesne") as Notlar

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
                    .setAction("Evet") {
                        startActivity(Intent(this@DetayActivity, NotKayitActivity::class.java))
                        finish()
                    }.show()
                return true
            }
            R.id.actionDuzenle-> {
                return true
                startActivity(Intent(this@DetayActivity,NotKayitActivity::class.java))
                finish()
            }else->return false
        }
        return super.onOptionsItemSelected(item)
    }
}