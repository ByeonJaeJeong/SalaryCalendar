package com.example.calender.model

import java.time.Year

data class CalendarInfo(
    //캘린더 출력 날짜
    var year: Int=0,
    var month : Int= 0,
    var dayOfMonth: Int =0,
    var dayOfWeek : Int =0
)
