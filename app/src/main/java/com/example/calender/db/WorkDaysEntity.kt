package com.example.calender.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName="workDays")
data class WorkDaysEntity(
    var wd_workplaceName : String,  //근무지
    @PrimaryKey var wd_date : String, //근무일자
    var wd_Color : String,
    var wd_workType: String,

    )
