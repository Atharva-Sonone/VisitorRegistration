package com.atharva.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class VisitorsList : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var visitorRecyclerView: RecyclerView
    private lateinit var visitorarraylist :ArrayList<FetchVisitor>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitors_list)
        title="Visitor's List"

        visitorRecyclerView =findViewById(R.id.visitorRecyclerView)
        visitorRecyclerView.layoutManager=LinearLayoutManager(this)
        visitorRecyclerView.setHasFixedSize(true)


        visitorarraylist= arrayListOf<FetchVisitor>()

        getVisitorData()

    }

    private fun getVisitorData() {
        dbref=FirebaseDatabase.getInstance().getReference("Visitors")

        dbref.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    for (userSnapshot in snapshot.children){
                        val visitor =userSnapshot.getValue(FetchVisitor::class.java)
                        visitorarraylist.add(visitor!!)


                    }

                    visitorRecyclerView.adapter=VisitorFetchAdaptor(visitorarraylist)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}