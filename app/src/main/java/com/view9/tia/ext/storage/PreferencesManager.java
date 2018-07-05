package com.view9.tia.ext.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.view9.tia.utils.Constants;


public class PreferencesManager {

    private SharedPreferences sharedPreferences;

    public PreferencesManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
    }


    public void save(String key, String value)
    {
        sharedPreferences.edit().putString(key,value).apply();
    }

    public void setBoolean(String key, Boolean value)
    {
        sharedPreferences.edit().putBoolean(key,value).apply();
    }

    public void setFirstLaunch(String key, Boolean value)
    {
        sharedPreferences.edit().putBoolean(key,value).apply();
    }
    public Boolean getFirstLaunch(String key)
    {
        return sharedPreferences.getBoolean(key,true);
    }


    public String get(String key)
    {
        return sharedPreferences.getString(key,null);
    }

    public Boolean getBoolean(String key)
    {
        return sharedPreferences.getBoolean(key,false);
    }




    public boolean isEmpty(String key)
    {
        return (sharedPreferences.getString(key,null) == null);
    }

    public void clear()
    {
        sharedPreferences.edit().clear().apply();
    }
}
