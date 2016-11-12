package com.text.dukang.knowheartmusic.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.model.Tab;

import com.text.dukang.knowheartmusic.ui.fragment.BaseFragmentActivity;
import com.text.dukang.knowheartmusic.ui.fragment.FragmentClient;
import com.text.dukang.knowheartmusic.ui.fragment.FragmentMarket;
import com.text.dukang.knowheartmusic.ui.fragment.FragmentChain;
import com.text.dukang.knowheartmusic.ui.fragment.FragmentMore;
import com.text.dukang.knowheartmusic.ui.view.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseFragmentActivity {

    private FrameLayout realtabcontent;
    private FragmentTabHost tabhost;
    private List<Tab> mTabs;

    @Override
    protected void setContent(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        realtabcontent = (FrameLayout) findViewById(R.id.realtabcontent);
        tabhost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabs = new ArrayList<>(2);
        initTab();
    }

    /**
     * 给底部导航设置数据，并设置选中状态
     */
    private void initTab() {
        Tab tab_chain = new Tab(FragmentChain.class, R.string.chain, R.drawable.select_icon_chain);
        Tab tab_client = new Tab(FragmentClient.class, R.string.client, R.drawable.select_icon_client);
        Tab tab_market = new Tab(FragmentMarket.class, R.string.market, R.drawable.select_icon_market);
        Tab tab_more = new Tab(FragmentMore.class, R.string.more, R.drawable.select_icon_more);
        mTabs.add(tab_chain);
        mTabs.add(tab_client);
        mTabs.add(tab_market);
        mTabs.add(tab_more);
        tabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(biuldIndicator(tab));
            tabhost.addTab(tabSpec, tab.getFragment(), null);
        }

        tabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabhost.setCurrentTab(0);
    }

    /**
     * 给底部导航设置数据
     */
    private View biuldIndicator(Tab tab) {
        View view = View.inflate(this, R.layout.tab_indicator, null);
        ImageView icon_tab = (ImageView) view.findViewById(R.id.icon_tab);
        TextView txt_indicator = (TextView) view.findViewById(R.id.txt_indicator);
        icon_tab.setImageResource(tab.getIcon());
        txt_indicator.setText(getString(tab.getTitle()));
        return view;
    }

    @Override
    protected void initData() {

    }
}
