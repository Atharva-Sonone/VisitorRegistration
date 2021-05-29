package com.atharva.miniproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResidentAdapter(private val residentList : ArrayList<FetchResident>) :RecyclerView.Adapter<ResidentAdapter.ResidentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentViewHolder {
        val itemview =LayoutInflater.from(parent.context).inflate(R.layout.residentsinglerow,parent,false)
        return ResidentViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ResidentViewHolder, position: Int) {
        val currentitem1 =residentList[position]
        holder.tvoflatno.text = currentitem1.flatNo
        holder.residentname.text =currentitem1.name
        holder.residentPhoneNumber.text=currentitem1.phoneNumber

    }

    override fun getItemCount(): Int {
        return residentList.size
    }


    class ResidentViewHolder (itemview : View):RecyclerView.ViewHolder(itemview){

        companion object{
            val flatno ="106"
        }
        val tvoflatno :TextView =itemview.findViewById(R.id.tvoflat)
        val residentname :TextView =itemview.findViewById(R.id.tvoname)
        val residentPhoneNumber :TextView=itemview.findViewById(R.id.tvophonenumbar)


        init {
            itemview.setOnClickListener {
                val intent = Intent(itemview.context, ResidentDetails::class.java)
                intent.putExtra("flatno", tvoflatno.text.toString())
                itemview.context.startActivity(intent)
            }
        }


    }


}