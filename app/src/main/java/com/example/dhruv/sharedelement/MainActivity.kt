package com.example.dhruv.sharedelement

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import com.example.dhruv.sharedelement.R.id.text
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_otheractivity.*

class MainActivity : AppCompatActivity(),animalItemClickListener   {


    override fun onAnimalItemClick(pos:Int, course:Course, sharedtext :TextView) {

        var intent =  Intent(this, otheractivity::class.java)

        intent.putExtra("text", course.text)
        intent.putExtra("back",course.imgsrc)


        intent.putExtra("transition", ViewCompat.getTransitionName(sharedtext))

        var options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                sharedtext,
                ViewCompat.getTransitionName(sharedtext)!!);

        startActivity(intent, options.toBundle());
    }


    var courses = ArrayList<Course>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("ACTIVITY1")

        Log.d("goo", "hh")
        courses.add(Course("apple", R.drawable.wa))
        courses.add(Course("banana", R.drawable.wb))
        courses.add(Course("orange", R.drawable.wc))
        courses.add(Course("melon", R.drawable.wa))

        Log.d("gh", "hh")

        courses.add(Course("pineapple", R.drawable.wb))
        courses.add(Course("kiwi", R.drawable.wc))

        courses.add(Course("guava", R.drawable.wa))
        courses.add(Course("litchi", R.drawable.wb))



        rvcourses.layoutManager = GridLayoutManager(
                this, 1,
                RecyclerView.VERTICAL,
                false
        )



        rvcourses.adapter = adapter(this,courses)



    }


        /*rvcourses.View.setOnClickListener
    {


        tt.text = courses[0].text
        tt.setBackgroundResource(courses[0].imgsrc)

        var i = Intent(this, otheractivity::class.java)
        var options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, findViewById(R.id.text), ViewCompat.getTransitionName(findViewById(R.id.tt))!!)
        startActivity(i, options.toBundle())

    }

    */

    }

