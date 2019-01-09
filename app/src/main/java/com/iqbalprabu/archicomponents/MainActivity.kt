package com.iqbalprabu.archicomponents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.iqbalprabu.archicomponents.data.entity.Habit
import com.iqbalprabu.archicomponents.view.habit.HabitAdapter
import com.iqbalprabu.archicomponents.view.habit.HabitViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mWordViewModel: HabitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWordViewModel = ViewModelProviders.of(this).get(HabitViewModel::class.java)

        val adapter = HabitAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        mWordViewModel.allWords.observe(this,
            Observer<List<Habit>> { listHabit -> listHabit?.let { adapter.setWords(it) } })


        fab.setOnClickListener {
            startActivity(Intent(this, AddHabitActivity::class.java)) }


    }
}
