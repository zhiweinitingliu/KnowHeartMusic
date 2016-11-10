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
import com.text.dukang.knowheartmusic.ui.fragment.FragmentCategory;
import com.text.dukang.knowheartmusic.ui.fragment.FragmentHome;
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

    private void initTab() {
        Tab tab_home = new Tab(FragmentHome.class, R.string.home, R.mipmap.ic_launcher);
        Tab tab_category = new Tab(FragmentCategory.class, R.string.category, R.mipmap.ic_launcher);
        mTabs.add(tab_home);
        mTabs.add(tab_category);

        tabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab : mTabs) {

            TabHost.TabSpec tabSpec = tabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(biuldIndicator(tab));

            tabhost.addTab(tabSpec, tab.getFragment(), null);
        }

        tabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabhost.setCurrentTab(0);
    }

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
