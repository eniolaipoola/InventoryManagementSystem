package com.dev.topefirstapplication.utility;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceBaseClass {

    private Context mContext;
    private static String USER_DETAILS;

    public SharedPreferenceBaseClass(Context context) {
        this.mContext = context;
    }

    public SharedPreferences loadPreference(String prefName) {
        return mContext.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    public void editPreference(String prefName, String key, String value) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(prefName,
                Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    /*public void saveLoginResponseInPref(LoginModel.LoginData loginData) {
        String json = new Gson().toJson(loginData);
        SharedPreferences.Editor editor = mContext.getSharedPreferences(
                AppConstant.APP_MAIN_PREFERENCE, Context.MODE_PRIVATE).edit();
        editor.putString(USER_DETAILS, json);
        editor.apply();
    }

    public LoginModel.LoginData fetchUserDetailsFromPref(){
        String json = this.loadPreference(AppConstant.APP_MAIN_PREFERENCE)
                .getString(USER_DETAILS, "");
        return new Gson().fromJson(json, LoginModel.LoginData.class);
    }*/

    public void clearPreference(String prefName) {
        SharedPreferences.Editor editor = mContext
                .getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
        editor.clear().apply();
    }
}
