package com.example.dhruv.sharedelement

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_otheractivity.*
import kotlinx.android.synthetic.main.activity_otheractivity.view.*
import kotlinx.android.synthetic.main.listitem.view.*

class adapter (
     val animalitemClickListener: animalItemClickListener,
        val courses: ArrayList<Course>
): RecyclerView.Adapter<adapter.CourseViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> 0
            else -> 1
        }
    }

    override fun getItemCount(): Int = courses.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =

            CourseViewHolder(
                    (parent.context.getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                            .inflate(
                                    when (viewType) {
                                        0 -> R.layout.listitem
                                        else -> R.layout.listitem
                                    },
                                    parent, false
                            )
            )


    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bindData(courses[position])


        ViewCompat.setTransitionName(holder.itemView.tex, courses[position].text)
        holder.itemView.setOnClickListener {

                animalitemClickListener.onAnimalItemClick(position, courses[position], it.tex)

        }



    }
             /*   var mcontext=holder.itemView.context

                var tt=holder.itemView.findViewById(R.id.tt) as TextView
                var tex=holder.itemView.findViewById(R.id.tex) as TextView
                holder.itemView.setOnClickListener {


                    tt.text = courses[position].text
                    tt.setBackgroundResource(courses[position].imgsrc)

                    var i = Intent(mcontext, otheractivity::class.java)
                    var options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, tex, ViewCompat.getTransitionName(tt)!!)
                    mcontext.startActivity(i, options.toBundle())

                }
*/





    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tex




        fun bindData(course: Course) {
            name.text = course.text
            name.setBackgroundResource(course.imgsrc)











                }


        }




    }


