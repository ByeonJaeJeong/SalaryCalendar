package com.example.calender.adapter


import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.ListAdapter
import com.example.calender.BottomDialogFragment
import com.example.calender.ViewHolder
import com.example.calender.model.CalendarInfo


class CalendarAdapter :
    ListAdapter<CalendarInfo,ViewHolder>(
            CalendarAdapterDiffcallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =getItem(position)
        // 0일경우 날짜표시 x
        if(item.dayOfMonth == 0){
            holder.dateNumber.visibility= View.GONE
    }
        //일요일
        if(item.dayOfWeek == 0){
            holder.dateNumber.setTextColor(Color.parseColor("#B22222"))
        }
        //토요일
        if(item.dayOfWeek == 6){
            holder.dateNumber.setTextColor(Color.BLUE)
        }

    holder.bind(item)
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    //데이터를 저장할 아이템리스트
   // val items = ArrayList<>()


    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }
}

