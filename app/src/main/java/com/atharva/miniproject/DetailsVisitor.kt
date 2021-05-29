package com.atharva.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailsVisitor : AppCompatActivity() {


    private lateinit var tvvname : TextView
    private lateinit var tvvphonenumber: TextView
    private lateinit var tvvflatno : TextView
    private lateinit var tvvreson : TextView
    private lateinit var tvvehicle : TextView
    private lateinit var tvvdate:TextView
    private lateinit var tvvtime:TextView
    private lateinit var dbref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_visitor)

        title="Visitor Details"



        val visitorid = intent.getStringExtra("VisitorID")




        tvvehicle = findViewById(R.id.tvvvehicle)
        tvvname = findViewById(R.id.tvvname)
        tvvphonenumber = findViewById(R.id.tvvphonenumber)
        tvvflatno = findViewById(R.id.tvvflatno)
        tvvreson = findViewById(R.id.tvvreason)
        tvvdate = findViewById(R.id.tvvdate)
        tvvtime = findViewById(R.id.tvvtime)


        dbref = FirebaseDatabase.getInstance().getReference("Visitors")
        dbref.child(visitorid.toString()).get().addOnSuccessListener {
            if (it.exists()) {
                val visitorname = it.child("visitorname").value
                val phonenumber = it.child("phonenumber").value
                val flatno = it.child("flatno").value
                val reason = it.child("reason").value
                val vehicle =it.child("vehicleno").value
                val date = it.child("date").value
                val time = it.child("time").value
                tvvehicle.apply { text=vehicle.toString() }
                tvvname.apply { text = visitorname.toString() }
                tvvphonenumber.apply { text = phonenumber.toString() }
                tvvflatno.apply { text = flatno.toString() }
                tvvreson.apply { text = reason.toString() }
                tvvdate.apply { text = date.toString() }
                tvvtime.apply { text = time.toString() }


            }

        }.addOnFailureListener {
            Toast.makeText(this, "Some Error Occurred ", Toast.LENGTH_LONG)
        }
    }
}