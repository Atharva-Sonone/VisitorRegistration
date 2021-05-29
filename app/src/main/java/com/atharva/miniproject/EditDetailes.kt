package com.atharva.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditDetailes : AppCompatActivity() {


    private lateinit var btnadd :Button
    private lateinit var dbref : DatabaseReference
    private lateinit var etoflatno : EditText
    private lateinit var etoname : EditText
    private lateinit var etophonenumber : EditText
    private lateinit var etoresitentnumber : EditText
    private lateinit var etostatus : EditText
    private lateinit var btnupdate:Button
    private lateinit var btnview:Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_detailes)
        title="Update Resident Details"

        btnadd=findViewById(R.id.btnadd)
        etoflatno=findViewById(R.id.etoflatno)
        etoname =findViewById(R.id.etoname)
        etophonenumber=findViewById(R.id.etophonenumber)
        etoresitentnumber=findViewById(R.id.etoresitentnumber)
        etostatus=findViewById(R.id.etostatus)
        btnupdate=findViewById(R.id.btnupdate)
        btnview=findViewById(R.id.btnview)


        btnadd.setOnClickListener {
            startActivity(Intent(this,AddSocietyMember::class.java))
        }

        btnview.setOnClickListener {
            startActivity(Intent(this,ResidentList::class.java))
        }


        btnupdate.setOnClickListener {

            updatedata()
        }


    }

    private fun updatedata() {
        val flatno= etoflatno.text.toString()
        val name =etoname.text.toString()
        val phoneNumber=etophonenumber.text.toString()
        val residentNumber =etoresitentnumber.text.toString()
        val status =etostatus.text.toString()


        if (flatno.isEmpty())
        {
            etoflatno.error="Please enter Flat No."

        }
        if (name.isEmpty())
        {
            etoname.error="Please enter Name"
        }
        if (phoneNumber.isEmpty())
        {
            etophonenumber.error="Please enter Phone Number"
        }

        if (residentNumber.isEmpty())
        {
            etoresitentnumber.error="Please enter No. of Resident"
        }

        if (status.isEmpty())
        {
            etostatus.error="Please enter name"
        }

        dbref=FirebaseDatabase.getInstance().getReference("Residents")

        val resident = mapOf<String,String>(
            "name" to name,
            "phoneNumber" to phoneNumber,
            "residentNumber" to residentNumber,
            "status" to status
        )
        dbref.child(flatno).updateChildren(resident).addOnSuccessListener {
            etoflatno.text.clear()
            etoname.text.clear()
            etophonenumber.text.clear()
            etoresitentnumber.text.clear()
            etostatus.text.clear()

            Toast.makeText(this,"Successfully Updated Resident", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Update Failed",Toast.LENGTH_LONG).show()
        }


    }
}