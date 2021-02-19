package com.example.calender

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="member")
data class MemberEntity (
    @PrimaryKey(autoGenerate = true) //기본적으로 순서대로 나옴
    var id: Long?,
    var email: String ="",
    var password:String ="",
    var name:String = ""
)

