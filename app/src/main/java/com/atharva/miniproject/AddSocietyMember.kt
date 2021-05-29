package com.atharva.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.atharva.miniproject.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddSocietyMember : AppCompatActivity() {



    private lateinit var dbref :DatabaseReference
    private lateinit var etoaddflatno :EditText
    private lateinit var etoaddname :EditText
    private lateinit var etoaddphonenumber :EditText
    private lateinit var etoaddresitentnumber :EditText
    private lateinit var etoaddstatus :EditText
    private lateinit var btnadd :Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_society_member)
        title="Add Society Member"


        etoaddflatno=findViewById(R.id.etoaddflatno)
        etoaddname =findViewById(R.id.etoaddname)
        etoaddphonenumber=findViewById(R.id.etoaddphonenumber)
        etoaddresitentnumber=findViewById(R.id.etoaddresitentnumber)
        etoaddstatus=findViewById(R.id.etoaddstatus)
        btnadd=findViewById(R.id.btnadd)


        btnadd.setOnClickListener {

            val flatno= etoaddflatno.text.toString()
            val name =etoaddname.text.toString()
            val phoneNumber=etoaddphonenumber.text.toString()
            val residentNumber =etoaddresitentnumber.text.toString()
            val status =etoaddstatus.text.toString()


            if (flatno.isEmpty())
            {
                etoaddflatno.error="Please enter Flat No."

            }
            if (name.isEmpty())
            {
                etoaddname.error="Please enter Name"
            }
            if (phoneNumber.isEmpty())
            {
                etoaddphonenumber.error="Please enter Phone Number"
            }

            if (residentNumber.isEmpty())
            {
                etoaddresitentnumber.error="Please enter No. of Resident"
            }

            if (status.isEmpty())
            {
                etoaddstatus.error="Please enter name"
            }



            dbref=FirebaseDatabase.getInstance().getReference("Residents")
            val resident =Resident(flatno,name,phoneNumber,residentNumber,status)
            dbref.child(flatno).setValue(resident).addOnSuccessListener {
                etoaddflatno.text.clear()
                etoaddname.text.clear()
                etoaddphonenumber.text.clear()
                etoaddresitentnumber.text.clear()
                etoaddstatus.text.clear()

                Toast.makeText(this,"Successfully Added Resident",Toast.LENGTH_LONG).show()

            }.addOnFailureListener {
                Toast.makeText(this,"Failed Added Resident",Toast.LENGTH_LONG).show()
            }



        }




    }
}