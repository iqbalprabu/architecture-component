package com.iqbalprabu.archicomponents.data.entity

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query


/**
 * Created by Iqbal Prabu Juliantoro
 * on 09/01/19.
 * Github: https://github.com/iqbalprabu
 * Facebook: https://facebook.com/ipj14
 **/

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(habit: Habit)

    @Query("DELETE FROM habitClass")
    fun deleteAll()

    @Query("SELECT * FROM habitClass ORDER BY habit ASC")
    fun getAllHabits(): LiveData<List<Habit>>

}