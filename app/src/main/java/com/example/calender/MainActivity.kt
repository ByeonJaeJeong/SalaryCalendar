package com.example.calender

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_member.*

class MainActivity : AppCompatActivity() ,MemberDAO {
    //사용자와 의 상호작용을 할수있게 준비하는 작업
    lateinit var  navController: NavController //나중에 정의하겠다
    var memberList: List<MemberEntity> = listOf<MemberEntity>()
    lateinit var db: MemberDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = nav_host_fragment.findNavController()
        db = MemberDatabase.getInstance(this)!!



    }



    override fun insert(Member: MemberEntity) {
        TODO("Not yet implemented")
        //1.MainThread(UI 보이는곳) vs WorkerThread[Background Thread] (안보이는 처리 Data 관련)
        //나중에는 코르틴을 사용해서 할것 지금은 추천은 하지않지만 배우는 느낌으로 돌아가는것 먼저
        //할예정
        @SuppressLint("StaticFieldLeak")
        object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg params: Unit?) {
                db.memberDAO().insert(Member)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAll()
            }
        }
    }

    override fun getAll(): List<MemberEntity> {
        TODO("Not yet implemented")
        val getTask = object : AsyncTask<Unit, Unit, Unit>(){

            override fun doInBackground(vararg params: Unit?) {
                memberList =db.memberDAO().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                print(result)
            }
        }
    }

    override fun deleteMember(Member: MemberEntity) {
        TODO("Not yet implemented")
    }


}