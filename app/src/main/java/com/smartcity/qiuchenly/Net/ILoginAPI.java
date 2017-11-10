package com.smartcity.qiuchenly.Net;

/**
 * Author: qiuchenly
 * Date   : 10/11/2017
 * Usage :
 * Lasted:2017 11 10
 * ProjectName:SmartRoadSystem
 * Create: 2017 11 10 , on 20:37
 */

public interface ILoginAPI {
  void login(String user,String pass,Callback.loginCallBack callBack);

  void getManageUser(Callback.getUserManageData getUserManageData);
}
