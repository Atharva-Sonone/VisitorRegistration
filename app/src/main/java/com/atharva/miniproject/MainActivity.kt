package com.atharva.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {



    private lateinit var cvlogout: CardView
    private lateinit var cvregistervisitor:CardView
    private lateinit var cvvisitorslist:CardView
    private lateinit var cveditdetails:CardView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Dashboard"

        cvlogout=findViewById(R.id.cvlogout)
        cvregistervisitor=findViewById(R.id.cvregistervisitor)
        cvvisitorslist=findViewById(R.id.cvvisitorslist)
        cveditdetails=findViewById(R.id.cveditdetails)


        cvregistervisitor.setOnClickListener {
            startActivity(Intent(this,RegisterVisitor::class.java))

        }
        cvvisitorslist.setOnClickListener {
            startActivity(Intent(this,VisitorsList::class.java))
        }

        cveditdetails.setOnClickListener {
            startActivity(Intent(this,EditDetailes::class.java))
        }


    }
}