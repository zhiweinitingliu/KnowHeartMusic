package com.text.dukang.knowheartmusic.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wdk on 2016/11/10.
 * 功能介绍：activity 的基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent(savedInstanceState);
        initView();
        initData();
    }

    protected abstract void setContent(Bundle savedInstanceState);

    protected abstract void initView();

    protected abstract void initData();
}


