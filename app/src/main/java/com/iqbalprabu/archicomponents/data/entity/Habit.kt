package com.iqbalprabu.archicomponents.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Iqbal Prabu Juliantoro
 * on 09/01/19.
 * Github: https://github.com/iqbalprabu
 * Facebook: https://facebook.com/ipj14
 **/

@Entity(tableName = "habitClass")
data class Habit(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id") val id :Int,
                @ColumnInfo(name = "habit") val mHabit: String)