package com.text.dukang.knowheartmusic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
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
import com.text.dukang.knowheartmusic.util.StatusBarUtil;
import com.text.dukang.knowheartmusic.util.nohttp.CallServer;
import com.text.dukang.knowheartmusic.util.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseFragmentActivity {
    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private FrameLayout realtabcontent;
    private FragmentTabHost tabhost;
    private NavigationView navigationView;
    private List<Tab> mTabs;
    int alpha_main = 0;
    int alpha_draw = 112;
    int alpha = 255;
    private int mAlpha = StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA;
    private int mStatusBarColor;

    private CallServer callServer;

    @Override
    protected void setContent(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        realtabcontent = (FrameLayout) findViewById(R.id.realtabcontent);
        tabhost = (FragmentTabHost) findViewById(R.id.tabhost);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setStatusBar();
        mTabs = new ArrayList<>(2);
        initTab();
    }

    protected void setStatusBar() {
        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(context, (DrawerLayout) findViewById(R.id.drawerlayout), mStatusBarColor, alpha_main);
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
