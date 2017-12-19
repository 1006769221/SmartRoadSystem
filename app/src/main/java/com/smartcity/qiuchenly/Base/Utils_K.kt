package com.smartcity.qiuchenly.Base

import java.util.*

/**
 * Author: QiuChenly
 * Date   : 2017/12/19
 * Usage :
 * Lasted:2017 12 19
 * ProjectName:SmartRoadSystem
 * Create: 2017 12 19 , on 10:35
 */
class Utils_K {
    companion object {
        /**
         * 获取当前时间
         * 返回字符串格式：2017.05.11 11:11
         */
        fun getNowDate(): String {
            val mCalender = Calendar.getInstance()
            return String.format("${mCalender.time.year}" +
                    ".${mCalender.time.month}." +
                    "${mCalender.time.day} " +
                    "${mCalender.time.hours}:${mCalender.time.minutes}")
        }


        fun InitDataBaseHelper() {
            //初始化表
            with(Utils.dataBaseHelper) {
                mCreateUserManageTabel()
                mCreateNewPayHistoryTable()
                mUser_insert(1, "辽A10001", "张三", 0)
                mUser_insert(2, "辽A10002", "李四", 0)
                mUser_insert(3, "辽A10003", "王五", 0)
                mUser_insert(4, "辽A10004", "赵六", 0)
                mUserCarHelper.createTable()
                mUserCarHelper.insert("1", "辽A10001", "user1")
                mUserCarHelper.insert("2", "辽A10002", "user2")
                mUserCarHelper.insert("3", "辽A10003", "user3")
                mUserCarHelper.insert("4", "辽A10004", "user4")
                mUserCarHelper.insert("1", "辽A10001", "user5")
            }

        }
    }
}