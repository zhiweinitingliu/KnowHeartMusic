package com.text.dukang.knowheartmusic.config;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;

/**
 * Created by wdk on 2016/11/12.
 * 功能介绍：
 */

public class MusicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        NoHttp.initialize(this);
    }
}
