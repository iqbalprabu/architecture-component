package com.iqbalprabu.archicomponents.data.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.iqbalprabu.archicomponents.data.RoomDatabaseInstance
import com.iqbalprabu.archicomponents.data.entity.Habit
import com.iqbalprabu.archicomponents.data.entity.HabitDao


/**
 * Created by Iqbal Prabu Juliantoro
 * on 09/01/19.
 * Github: https://github.com/iqbalprabu
 * Facebook: https://facebook.com/ipj14
 **/

class HabitRepository(application: Application) {

    private var habitDao: HabitDao? = null
    private lateinit var listLiveData: LiveData<List<Habit>>

    init {
        val habitRoomDatabase = RoomDatabaseInstance.getInstance(application)
        habitDao = habitRoomDatabase?.habitDao()
        habitDao?.let {
            listLiveData = it.getAllHabits()
        }
    }

    fun getAllHabits(): LiveData<List<Habit>> {
        return listLiveData
    }

    fun insert(word: Habit) {
        habitDao?.let { InsertAsyncTask(it).execute(word) }
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: HabitDao) : AsyncTask<Habit, Void, Void>() {

        override fun doInBackground(vararg params: Habit): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

}