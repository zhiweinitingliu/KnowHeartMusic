package com.text.dukang.knowheartmusic.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wdk on 2016/11/17.
 * 功能介绍：SharedPreferences的工具类
 */

public class SpUtil {

    public static SharedPreferences sharedPreferences;

    public static SharedPreferences getSp(Context context) {

        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("JYBD", Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }
}
