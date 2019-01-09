package com.iqbalprabu.archicomponents.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.iqbalprabu.archicomponents.data.entity.Habit
import com.iqbalprabu.archicomponents.data.entity.HabitDao
import kotlin.reflect.KClass


/**
 * Created by Iqbal Prabu Juliantoro
 * on 09/01/19.
 * Github: https://github.com/iqbalprabu
 * Facebook: https://facebook.com/ipj14
 **/

@Database(entities = [Habit::class], version = 1)
abstract class RoomDatabaseInstance: RoomDatabase() {


    abstract fun habitDao(): HabitDao

    companion object {
        private var INSTANCE: RoomDatabaseInstance? = null

        fun getInstance(context: Context): RoomDatabaseInstance? {
            if(INSTANCE == null) {
                synchronized(RoomDatabaseInstance) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        RoomDatabaseInstance::class.java, "room-db")
                        .addCallback(sRoomDatabaseCallback)
                        .build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

        private val sRoomDatabaseCallback: RoomDatabase.Callback = object: RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { PopulateDbAsync(it).execute() }
            }
        }

        class PopulateDbAsync(db: RoomDatabaseInstance): AsyncTask<Void, Void, Void>() {

            private val mDao: HabitDao = db.habitDao()

            override fun doInBackground(vararg params: Void?): Void? {
                mDao.deleteAll()
                var word = Habit(0, "Hello")
                mDao.insert(word)
                word = Habit (0, "World")
                mDao.insert(word)
                return null
            }


        }
    }

}