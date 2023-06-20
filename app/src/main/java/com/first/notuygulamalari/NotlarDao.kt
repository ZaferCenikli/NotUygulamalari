package com.first.notuygulamalari

import android.annotation.SuppressLint
import android.content.ContentValues

class NotlarDao {


    @SuppressLint("Range")
    fun tumNotlar(vt:VeriTabaniYardimcisi):ArrayList<Notlar>{
        val db=vt.readableDatabase
        val notlarListe=ArrayList<Notlar>()
        val a=db.rawQuery("SELECT * FROM notlar",null)

        while (a.moveToNext()){
            val not=Notlar(a.getInt(a.getColumnIndex("not_id")),
                a.getString(a.getColumnIndex("not_ad")),
                a.getInt(a.getColumnIndex("not1")),
                a.getInt(a.getColumnIndex("not2")))
            notlarListe.add(not)

        }
        return notlarListe

    }

    fun notSil(zafer:VeriTabaniYardimcisi,not_id:Int){
        val db=zafer.readableDatabase
        db.delete("notlar","not_id=?", arrayOf(not_id.toString()))
        db.close()
    }
    fun notEkle(vt:VeriTabaniYardimcisi,ders_ad:String,not1:Int,not2:Int){
        val db=vt.readableDatabase
        val values=ContentValues()
        values.put("not_ad",ders_ad)
        values.put("not1",not1)
        values.put("not2",not2)

        db.insertOrThrow("notlar",null,values)
        db.close()

    }
    fun notGuncelle(vt:VeriTabaniYardimcisi,not_id:Int,not_ad:String,not1:Int,not2:Int){
        val db=vt.readableDatabase
        val values=ContentValues()
        values.put("not_ad",not_ad)
        values.put("not1",not1)
        values.put("not2",not2)

        db.update("notlar",values,"not_id=?", arrayOf(not_id.toString()))
        db.close()

    }
}