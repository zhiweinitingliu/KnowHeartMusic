package com.text.dukang.knowheartmusic.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.util.StatusBarUtil;

/**
 * Created by wdk on 2016/11/10.
 * 功能介绍：activity 的基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Context context;
    int alpha_main = 0;
    public int mStatusBarColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContent(savedInstanceState);
        initView();
        initData();
        setStatusBarColor();
    }

    protected abstract void setContent(Bundle savedInstanceState);

    protected abstract void initView();

    protected abstract void initData();

    /**
     * 设置状态栏的颜色
     */
    private void setStatusBarColor() {
        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColor(BaseActivity.this,mStatusBarColor, alpha_main);
    }
}


