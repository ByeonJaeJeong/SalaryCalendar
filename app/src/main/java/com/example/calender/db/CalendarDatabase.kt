package com.example.calender.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(WorkDaysEntity::class,WorkPlaceEntity::class), version = 1,exportSchema = false)
abstract class CalendarDatabase :RoomDatabase() {
    abstract fun CalendarDAO():CalendarDAO

    companion object {
        private var instance: CalendarDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CalendarDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalendarDatabase::class.java,
                    "calendarDatabase"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}