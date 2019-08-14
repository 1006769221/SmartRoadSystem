package com.smartcity.qiuchenly.function.PersonalCenter

import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.smartcity.qiuchenly.Base.SQ_PayHistoryCursor
import com.smartcity.qiuchenly.Base.SharedContext
import com.smartcity.qiuchenly.Base.Utils
import com.smartcity.qiuchenly.R
import kotlinx.android.synthetic.main.personal_page_prepaid_rv_view.view.*

/**
 * Author: QiuChenly
 * Date   : 2017/12/18
 * Usage :
 * Lasted:2017 12 18
 * ProjectName:SmartRoadSystem
 * Create: 2017 12 18 , on 20:30
 */
class personal_payHistoryRV(private var mList: List<SQ_PayHistoryCursor>) :
        RecyclerView.Adapter<personal_payHistoryRV.VH>(), View.OnLongClickListener {

    override fun onBindViewHolder(h: VH?, position: Int) {
        when (mList.isEmpty()) {
            false -> {
                with(h?.v) {
                    this!!.prepaid_payUser?.text = "充值人:" + mList[position].whoPay
                    this.tag = position
                    this.prepaid_payCarID?.text = "车牌号:" + mList[position].carID
                    this.prepaid_payPays?.text = "充值:" + mList[position].pay
                    this.prepaid_payTotals?.text = "余额:" + mList[position].totalMoney
                    this.prepaid_payTime?.text = mList[position].id.toString()
                    this.prepaid_payTimes?.text = "充值时间：\n" + mList[position].payTime
                }
                h?.v?.setOnLongClickListener(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return when (mList.isEmpty()) {
            true -> 1
            false -> mList.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val vs = View.inflate(
                parent.context,
                R.layout.personal_page_prepaid_rv_view,
                null)
        val has = VH(vs)
        val t = TextView(parent.context)
        t.text = "暂无历史记录"
        t.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        )
        t.setTextColor(Color.parseColor("#ffffff"))
        t.gravity = Gravity.CENTER
        t.textSize = 20f
        //t.setBackgroundColor(Color.BLACK)
        val noHasParent = VH(t)
        return when (viewType) {
            NULLDATA -> noHasParent
            else -> has
        }
    }

    class VH(var v: View) : RecyclerView.ViewHolder(v)


    //TODO : BUG = 根据数据库内记载的下标获取实际数据导致的数据溢出崩溃,等待修正.Bug级别:low
    override fun onLongClick(v: View): Boolean {
        Utils.dataBaseHelper.mPay_History_DeleteItems(
                mList[v.tag.toString().toInt()].id.toString())
        val a = mList.toMutableList()
        a.removeAt(v.tag.toString().toInt())
        mList = a
        this.notifyItemRemoved(v.tag.toString().toInt())
        Snackbar.make(v.rootView,"已删除此数据",Snackbar.LENGTH_SHORT)
                .show()
        return true
    }

    fun updateData(mList: List<SQ_PayHistoryCursor>) {
        this.mList = mList
    }

    companion object {
        val NULLDATA = 1000
    }

    override fun getItemViewType(position: Int): Int {
        if (mList.size <= 0) {
            return NULLDATA
        }
        return super.getItemViewType(position)
    }
}