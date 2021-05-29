package com.atharva.miniproject



import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class VisitorFetchAdaptor(private val visitorlist:ArrayList<FetchVisitor>): RecyclerView.Adapter<VisitorFetchAdaptor.VisitorFetchViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitorFetchViewHolder {
        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.visitorsinglerow,parent,false)
        return VisitorFetchViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: VisitorFetchViewHolder, position: Int) {
        val currentitem =visitorlist[position]
        holder.tvvid.text =currentitem.visitorid
        holder.tvvname.text=currentitem.visitorname
        holder.tvtimevisited.text=currentitem.time
        holder.tvvisitorphone.text=currentitem.phonenumber
        holder.tvvisitedflat.text=currentitem.flatno




    }

    override fun getItemCount(): Int {
        return visitorlist.size
    }


    class VisitorFetchViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val tvvid :TextView = itemview.findViewById(R.id.tvvid)
        val tvvname:TextView= itemview.findViewById(R.id.tvvname)
        val tvtimevisited:TextView=itemview.findViewById(R.id.tvtimevisited)
        val tvvisitorphone:TextView=itemview.findViewById(R.id.tvvisitorphone)
        val tvvisitedflat:TextView=itemview.findViewById(R.id.tvvisitedflat)


        init {
            itemview.setOnClickListener {
                val intent =Intent(itemview.context, DetailsVisitor::class.java)

                intent.putExtra("VisitorID", tvvid.text.toString())
                itemview.context.startActivity(intent)
            }
        }


    }
}