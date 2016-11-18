package com.text.dukang.knowheartmusic.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.ui.activity.BuyManagerActivity;
import com.text.dukang.knowheartmusic.ui.activity.ChainOrderStatisticActivity;
import com.text.dukang.knowheartmusic.ui.base.BaseFragment;

import java.util.List;

/**
 * Created by wdk on 2016/11/10.
 * 功能介绍：店铺
 */

public class FragmentChain extends BaseFragment implements View.OnClickListener {

    private LinearLayout icon_data_statistic;
    private LinearLayout icon_buy_manager;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chain, container, false);
        icon_data_statistic= (LinearLayout) view.findViewById(R.id.icon_data_statistic);
        icon_buy_manager= (LinearLayout) view.findViewById(R.id.icon_buy_manager);
        icon_data_statistic.setOnClickListener(this);
        icon_buy_manager.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.icon_data_statistic:
                Intent intent_date_statistic=new Intent(context, ChainOrderStatisticActivity.class);
                startActivity(intent_date_statistic);
                break;
            case R.id.icon_buy_manager:
                Intent intent_buy_manager=new Intent(context,BuyManagerActivity.class);
                startActivity(intent_buy_manager);
                break;
        }
    }
}
