package com.example.calender.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WorkPlace")
data class WorkPlaceEntity(
    @PrimaryKey var wp_name : String,   //근무지이름
    var wp_salaryType : String,  //급여형태 월급 주급 기간
    var wp_salaryDay : Int,  //급여지급일
    var wp_calculation_preiod : Int, //급여계산기간
    var wp_hourSalary : Int, //시급
    var wp_Weekly_vacation_pay : Boolean,//주휴수당 여부
    var wp_tax : Boolean //세금여부
)
