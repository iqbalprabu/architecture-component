package com.iqbalprabu.archicomponents

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iqbalprabu.archicomponents.data.entity.Habit
import com.iqbalprabu.archicomponents.view.habit.HabitViewModel
import kotlinx.android.synthetic.main.activity_add_habit.*

class AddHabitActivity : AppCompatActivity() {

    private lateinit var mWordViewModel: HabitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_habit)

        mWordViewModel = ViewModelProviders.of(this).get(HabitViewModel::class.java)

        btnSave.setOnClickListener {
            val word = edtHabit.text.toString()

            if(word.isEmpty() || word.isBlank()) {
                edtHabit.error = "Habit is required"
            } else edtHabit.error = null

            mWordViewModel.insert(Habit(0, word))
            finish()
        }
    }
}
