package com.atharva.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ResidentList : AppCompatActivity() {
    private lateinit var dbref :DatabaseReference
    private lateinit var residentrecyclerview : RecyclerView
    private lateinit var residentarraylist : ArrayList<FetchResident>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_list)
        title="Resident List"



        residentrecyclerview =findViewById(R.id.rvresident)
        residentrecyclerview.layoutManager= LinearLayoutManager(this)
        residentrecyclerview.setHasFixedSize(true)


        residentarraylist= arrayListOf<FetchResident>()
        getResidentData()
    }

    private fun getResidentData() {

        dbref=FirebaseDatabase.getInstance().getReference("Residents")
        dbref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    for (userSnapshot in snapshot.children){
                        val resident =userSnapshot.getValue(FetchResident::class.java)
                        residentarraylist.add(resident!!)
                    }
                    residentrecyclerview.adapter=ResidentAdapter(residentarraylist)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}