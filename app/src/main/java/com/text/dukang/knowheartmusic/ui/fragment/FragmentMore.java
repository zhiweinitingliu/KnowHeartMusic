package com.text.dukang.knowheartmusic.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.ui.base.BaseFragment;

/**
 * Created by wdk on 2016/11/12.
 * 功能介绍：更多
 */

public class FragmentMore extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
