package com.first.notuygulamalari

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NotlarAdapter(var context: Context,var NotlarListe:List<Notlar>)
    :RecyclerView.Adapter<NotlarAdapter.CardTasarim>() {

    inner class CardTasarim(tasarim:View):RecyclerView.ViewHolder(tasarim){

        var notCard:CardView
        var textViewDers:TextView
        var textViewNot1:TextView
        var textViewNot2:TextView

        init {
            notCard=tasarim.findViewById(R.id.notCard)
            textViewDers=tasarim.findViewById(R.id.textViewDers)
            textViewNot1=tasarim.findViewById(R.id.textViewNot1)
            textViewNot2=tasarim.findViewById(R.id.textViewNot1)
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarim {
        var carTasarimAktarma=LayoutInflater.from(context).inflate(R.layout.not_card,parent,false)
        return CardTasarim(carTasarimAktarma)

    }

    override fun getItemCount(): Int {
        return NotlarListe.size

    }

    override fun onBindViewHolder(holder: CardTasarim, position: Int) {
        val not =NotlarListe.get(position)

        holder.textViewDers.text=not.not_ad
        holder.textViewNot1.text= not.not1.toString()
        holder.textViewNot2.text=not.not2.toString()
        holder.notCard.setOnClickListener {

            val intent=Intent(context,DetayActivity::class.java)
            intent.putExtra("nesne",not)


        }


    }


}