package com.example.calender.fragment

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calender.MemberDatabase
import com.example.calender.MemberEntity
import com.example.calender.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_member.*


class memberFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var db: MemberDatabase
    var memberList : List<MemberEntity> = listOf<MemberEntity>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_member, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        db = MemberDatabase.getInstance(this)!!

        memberJoin_btn.setOnClickListener {
            if (memberPW_edit.text.toString() == memberPW_edit2.text.toString()) {
                var member = MemberEntity(
                    null,
                    memberEmail_edit.text.toString(),
                    memberPW_edit.text.toString(),
                    memberName_edit.text.toString()
                )
                insertMember(member)
            }
            else{
                Toast.makeText(this.context,"패스워드가 맞지않습니다.",Toast.LENGTH_SHORT).show()
            }
        }


    }//view oncreated
    //1.Insert Data
    fun insertMember(member: MemberEntity){
        //1.MainThread(UI 보이는곳) vs WorkerThread[Background Thread] (안보이는 처리 Data 관련)
        //나중에는 코르틴을 사용해서 할것 지금은 추천은 하지않지만 배우는 느낌으로 돌아가는것 먼저
        //할예정
        @SuppressLint("StaticFieldLeak")
        object : AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg params: Unit?) {
               db.memberDAO().insert(member)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMember()
            }
        }

    }
    //2.Get Data
    fun getAllMember(){
        val getTask = object : AsyncTask<Unit,Unit,Unit>(){

            override fun doInBackground(vararg params: Unit?) {
                memberList =db.memberDAO().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecyclerView(memberList)
            }
        }

    }
    //3. Delete Data
    fun deleteMember(){

    }
    //4. Set RecyclerView
    fun setRecyclerView(){

    }
}