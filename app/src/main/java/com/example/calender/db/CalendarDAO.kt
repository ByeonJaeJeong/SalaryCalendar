package com.example.calender.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CalendarDAO {
    @Insert
    fun insertWorkDays(workDaysEntity: WorkDaysEntity)
    @Insert
    fun insertWorkPlace(workPlaceEntity: WorkPlaceEntity)
}