package com.iqbalprabu.archicomponents.view.habit

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.iqbalprabu.archicomponents.R
import com.iqbalprabu.archicomponents.data.entity.Habit


/**
 * Created by Iqbal Prabu Juliantoro
 * on 09/01/19.
 * Github: https://github.com/iqbalprabu
 * Facebook: https://facebook.com/ipj14
 **/

class HabitAdapter internal constructor(context: Context): RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var habitList: List<Habit>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return HabitViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return if(habitList != null) {
           habitList!!.size
       } else 0
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        if(habitList != null) {
            habitList?.let {
                val habit = it[position].mHabit
                holder.habitItemView.text = habit
            }
        } else holder.habitItemView.text = "No Word"
    }

    internal fun setWords(habitsList: List<Habit>) {
        this.habitList = habitsList
        notifyDataSetChanged()
    }

    inner class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val habitItemView: TextView

        init {
            habitItemView = itemView.findViewById(R.id.textView)
        }
    }

}