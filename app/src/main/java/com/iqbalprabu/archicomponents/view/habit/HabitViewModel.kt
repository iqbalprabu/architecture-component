package com.iqbalprabu.archicomponents.view.habit

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.iqbalprabu.archicomponents.data.entity.Habit
import com.iqbalprabu.archicomponents.data.repository.HabitRepository


/**
 * Created by Iqbal Prabu Juliantoro
 * on 09/01/19.
 * Github: https://github.com/iqbalprabu
 * Facebook: https://facebook.com/ipj14
 **/

class HabitViewModel(application: Application): AndroidViewModel(application) {

    private lateinit var habitRepository: HabitRepository
    var allWords: LiveData<List<Habit>>

    init {
        habitRepository = HabitRepository(application)
        allWords = habitRepository.getAllHabits()
    }

    fun insert(habit: Habit) {
        habitRepository.insert(habit)
    }

}