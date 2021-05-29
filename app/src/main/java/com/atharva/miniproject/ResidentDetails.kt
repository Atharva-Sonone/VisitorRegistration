package com.atharva.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ResidentDetails : AppCompatActivity() {


    private lateinit var tvflatno :TextView
    private lateinit var tvresidentname: TextView
    private lateinit var tvresidentphonenumber :TextView
    private lateinit var tvresidentliving :TextView
    private lateinit var tvstatus :TextView
    private lateinit var dbref :DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_details)
        title="Resident Details"

        val flatno =intent.getStringExtra("flatno")
        tvflatno=findViewById(R.id.tvflat)
        tvresidentname=findViewById(R.id.tvresidentname)
        tvresidentphonenumber=findViewById(R.id.tvresidentphonenumber)
        tvresidentliving=findViewById(R.id.tvresidentliving)
        tvstatus=findViewById(R.id.tvstatus)



        tvflatno.apply { text=flatno.toString() }

        dbref=FirebaseDatabase.getInstance().getReference("Residents")
        dbref.child(flatno.toString()).get().addOnSuccessListener {
            if (it.exists())
            {
                val residentname =it.child("name").value
                val phonenumber =it.child("phoneNumber").value
                val residentliving =it.child("nooOfResident").value
                val status =it.child("ownerTenant").value

                tvresidentname.apply { text=residentname.toString() }
                tvresidentphonenumber.apply { text=phonenumber.toString() }
                tvresidentliving.apply { text=residentliving.toString() }
                tvstatus.apply { text =status.toString() }

            }else
            {
                Toast.makeText(this,"invalid ",Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this,"invalid ",Toast.LENGTH_LONG).show()
        }



    }
}