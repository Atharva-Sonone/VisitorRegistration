package com.atharva.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class RegisterVisitor : AppCompatActivity() {

    private lateinit var etvisitorname :EditText
    private lateinit var etvphonenumber:EditText
    private lateinit var etvflatno:EditText
    private lateinit var etvreason:EditText
    private lateinit var etvvehicleno:EditText
    private lateinit var etvtime:EditText
    private lateinit var etvdate:EditText
    private lateinit var btregister:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_visitor)
        title="Register Visitor"

        etvisitorname=findViewById(R.id.etvisitorname)
        etvphonenumber=findViewById(R.id.etvphonenumber)
        etvflatno=findViewById(R.id.etvflatno)
        etvreason=findViewById(R.id.etvreason)
        etvvehicleno=findViewById(R.id.etvvehicleno)
        etvtime=findViewById(R.id.etvtime)
        etvdate=findViewById(R.id.etvdate)
        btregister=findViewById(R.id.btregister)

        btregister.setOnClickListener {
            saveVisitor()
        }

    }

    private fun saveVisitor() {
        val visitorname=etvisitorname.text.toString().trim()
        val phonenumber=etvphonenumber.text.toString().trim()
        val flatno=etvflatno.text.toString().trim()
        val reason=etvreason.text.toString().trim()
        val vehicleno =etvvehicleno.text.toString().trim()
        val time=etvtime.text.toString().trim()
        val date=etvdate.text.toString().trim()


        if (visitorname.isEmpty())
        {
            etvisitorname.error="Please enter name"
            return
        }
        if (phonenumber.isEmpty()) {

            etvphonenumber.error = "Please enter Phone Number"
            return
        }
        if (flatno.isEmpty()) {
            etvflatno.error = "Please enter flat no"
            return
        }
        if (reason.isEmpty()) {
            etvreason.error = "Please enter Reason"
            return
        }

        if (time.isEmpty()) {
            etvtime.error = "Please enter Reason"
            return
        }

        if (date.isEmpty()) {
            etvdate.error = "Please enter Reason"
            return
        }


        val ref =FirebaseDatabase.getInstance().getReference("Visitors")
        val visitorid =ref.push().key.toString()

        val visitormodel =VisitorModel(visitorid,visitorname,phonenumber,flatno,reason,vehicleno,time,date)
        ref.child(visitorid).setValue(visitormodel).addOnCompleteListener {
            etvisitorname.text.clear()
            etvphonenumber.text.clear()
            etvflatno.text.clear()
            etvreason.text.clear()
            etvtime.text.clear()
            etvdate.text.clear()
            etvvehicleno.text.clear()




            Toast.makeText(applicationContext,"Registered Successfully",Toast.LENGTH_LONG).show()
        }

    }
}