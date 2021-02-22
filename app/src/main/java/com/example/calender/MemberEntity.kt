package com.example.calender

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="member")
data class MemberEntity (
    @PrimaryKey var email: String ,
    var password:String ="",
    var name:String = ""
)

