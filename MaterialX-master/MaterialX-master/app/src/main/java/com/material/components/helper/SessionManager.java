package com.material.components.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static String TAG = SessionManager.class.getName();
    SharedPreferences preferences;
    Context context;
    SharedPreferences.Editor  editor;
    int PRE_MODE = 1;



    private static  final String NAME = "android_demo";



    private static  final String ID = "android_demo";
    private  static  final  String KEY_LOGIN = "isLogin";

    public SessionManager(Context context)
    {
        this.context =context;
        preferences  = context.getSharedPreferences(NAME,context.MODE_PRIVATE);
        editor = preferences.edit();
    }


    public void setIDLogin(String IDs)
    {
        editor.putString(ID,IDs);
        editor.commit();
    }

    public String getIDLogin()
    {
        return preferences.getString(ID,null);
    }

    public void SetLogin(boolean isLogin)
    {
        editor.putBoolean(KEY_LOGIN,isLogin);
        editor.commit();
    }

    public boolean Check()
    {
        return preferences.getBoolean(KEY_LOGIN,false);
    }

}
