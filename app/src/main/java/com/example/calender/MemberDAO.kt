package com.example.calender

import android.os.AsyncTask
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface MemberDAO {
    @Insert(onConflict = REPLACE) //겹칠경우 덮어 씌운다
    fun insert(Member: MemberEntity)

    @Query("Select * From Member")
    fun getAll(): List<MemberEntity>

    @Delete
    fun deleteMember(Member: MemberEntity)
}