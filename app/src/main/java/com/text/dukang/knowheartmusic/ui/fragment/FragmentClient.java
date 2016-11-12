package com.text.dukang.knowheartmusic.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.text.dukang.knowheartmusic.ui.base.BaseFragment;

/**
 * Created by wdk on 2016/11/12.
 * 功能介绍：客户
 */

public class FragmentClient extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("clientFragment");
        return textView;
    }

    @Override
    protected void initData() {

    }
}
