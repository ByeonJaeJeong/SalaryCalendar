package com.example.calender


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calender.fragment.memberFragment


@Database(entities =  arrayOf(MemberEntity::class),version = 1)
abstract class MemberDatabase : RoomDatabase() {
    abstract  fun memberDAO() : MemberDAO

    companion object{
        var INSTANCE :MemberDatabase? =null

        fun getInstance(context: Context) :MemberDatabase?{
            if(INSTANCE ==null){
                synchronized(MemberDatabase::class){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,
                    MemberDatabase::class.java,"member.db")
                        .fallbackToDestructiveMigration()
                        //DB를 한번 생성하고나서 중간에 테이블의 수정이 있다면 version 을 올린다면 모두 지우고 새로 생성
                        .build()
                }
            }
            return INSTANCE
        }
        fun destoryInstance(){
            INSTANCE = null
        }
    }
}