package com.text.dukang.knowheartmusic.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by wdk on 2016/11/10.
 * 功能介绍：
 */

public abstract class BaseFragmentActivity extends FragmentActivity {

    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContent(savedInstanceState);
        initView();
        initData();
    }

    protected abstract void setContent(Bundle savedInstanceState);

    protected abstract void initView();

    protected abstract void initData();
}
