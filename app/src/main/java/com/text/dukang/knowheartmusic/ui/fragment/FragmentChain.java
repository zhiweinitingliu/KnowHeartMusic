package com.text.dukang.knowheartmusic.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.ui.base.BaseFragment;
import com.text.dukang.knowheartmusic.util.StatusBarUtil;

/**
 * Created by wdk on 2016/11/10.
 * 功能介绍：店铺
 */

public class FragmentChain extends BaseFragment {

    int alpha = 0;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chain, container, false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
