package com.text.dukang.knowheartmusic.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.ui.base.BaseActivity;
import com.text.dukang.knowheartmusic.util.nohttp.CallServer;
import com.text.dukang.knowheartmusic.util.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
 * Created by wdk on 2016/11/16.
 * 功能介绍：  门店实物订单
 */

public class ChainOrderStatisticActivity extends BaseActivity {
    private static final String TAG = "ChainOrderStatisticActi";

    private LineChart lineChart;
    private CallServer callServer;
//    "appkey":"5eda100684453dba7579533b46748993"

    @Override
    protected void setContent(Bundle savedInstanceState) {
        setContentView(R.layout.activity_chain_order);
    }

    @Override
    protected void initView() {
        lineChart = (LineChart) findViewById(R.id.chain_order_linechart);
    }

    @Override
    protected void initData() {
        callServer = CallServer.getRequestInstance();
        String url = "http://ceshi.jybd.cn/chainsell/index.php?";
        Request request = NoHttp.createStringRequest(url, RequestMethod.GET);
        request.add("act", "chain_order_statis");
        request.add("op", "index");
        request.add("appkey", "5eda100684453dba7579533b46748993");
        request.add("orderState", "20");
        request.add("statisType", "day");
        request.add("search_time", "2016-10-25");
        request.add("searchweek_year", "2016");
        request.add("searchweek_month", "10");
        request.add("searchweek_month", "10");


        callServer.add(context, 101, request, dataCallBack, false, false);
    }

    HttpListener dataCallBack = new HttpListener() {
        @Override
        public void onSucceed(int what, Response response) {
            Log.e(TAG, "onSucceed: tongji--data:::" + response.get().toString());
        }

        @Override
        public void onFailed(int what, Response response) {
            Log.e(TAG, "onFailed:----- " + response.get());
        }
    };
}
