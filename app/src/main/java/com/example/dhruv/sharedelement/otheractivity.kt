package com.example.dhruv.sharedelement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.v4.view.ViewCompat.setTransitionName
import android.os.Build
import android.widget.ImageView
import android.widget.TextView



class otheractivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otheractivity)
        setTitle("Activity2")





                val extras = intent.extras
                val viewtext = extras!!.getString("text")
                val viewabck=extras!!.getInt("back")

                val textview = findViewById(R.id.tt) as TextView

                textview.setText(viewtext)
                textview.setBackgroundResource(viewabck)



                    val imageTransitionName = extras.getString("transition")
                    textview.setTransitionName(imageTransitionName)



            }


        }









