package com.text.dukang.knowheartmusic.ui.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.ui.base.BaseActivity;
import com.text.dukang.knowheartmusic.util.SpUtil;
import com.text.dukang.knowheartmusic.util.nohttp.CallServer;
import com.text.dukang.knowheartmusic.util.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wdk on 2016/11/16.
 * 功能介绍：  门店实物订单
 */

public class ChainOrderStatisticActivity extends BaseActivity {
    private static final String TAG = "ChainOrderStatisticActi";

    private LineChart lineChart;
    private CallServer callServer;
    private String appkey;

    /**
     * 统计方式有三种
     * 1   按天统计
     * 2   按周统计
     * 3   按月统计
     */
    private int statistic_method = 1;

    private LineChart chart;
    private LineData data;
    private ArrayList<String> xVals;
    private LineDataSet dataSet;
    private ArrayList<Entry> yVals;
    private Random random;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        chart=new LineChart(this);
////        setContentView(chart);
//        setContentView(R.layout.activity_chain_order);
//        chart = (LineChart) findViewById(R.id.chain_order_linechart);
//        xVals=new ArrayList<>();
//        yVals=new ArrayList<>();
//        random=new Random();
//        for(int i=0;i<12;i++){
//            float profix=random.nextFloat();
//            yVals.add(new Entry(profix,i));
//            xVals.add((i+1)+"月");
//        }
//        dataSet=new LineDataSet(yVals,"公司年度利润");
//        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
////        data=new LineData(xVals,dataSet);
//        data=new LineData(xVals,dataSet);
//        chart.setData(data);
//        chart.setDescription("公司年度利润");
//        chart.animateY(3000);
//    }


    @Override
    protected void setContent(Bundle savedInstanceState) {
        setContentView(R.layout.activity_chain_order);
    }

    @Override
    protected void initView() {
//        lineChart = (LineChart) findViewById(R.id.chain_order_linechart);
        chart = (LineChart) findViewById(R.id.chain_order_linechart);
        xVals = new ArrayList<>();
        yVals = new ArrayList<>();
        random = new Random();
    }

    @Override
    protected void initData() {

        appkey = SpUtil.getSp(context).getString("appkey", "");
        Log.e(TAG, "initData: appkey------" + appkey);

        if (appkey == null || appkey.length() <= 0) {
            return;
        }

        callServer = CallServer.getRequestInstance();
        String url = "http://ceshi.jybd.cn/chainsell/index.php?";
        Request request = NoHttp.createStringRequest(url, RequestMethod.GET);
        request.add("act", "chain_order_statis");
        request.add("op", "index");
        request.add("appkey", appkey);
        request.add("orderState", "20");
        request.add("statisType", "day");
        request.add("search_time", "2016-10-25");
//        request.add("searchweek_year", "2016");
//        request.add("searchweek_month", "10");
//        request.add("searchweek_month", "10");

        callServer.add(context, 101, request, dataCallBack, false, false);
    }

    HttpListener dataCallBack = new HttpListener() {
        @Override
        public void onSucceed(int what, Response response) {
            Log.e(TAG, "onSucceed: tongji--data:::" + response.get().toString());

            if (response.get() == null) {
                return;
            }
            switch (what) {
                case 101://请求统计数据成功
                    parseStatisticData(response.get().toString());
                    break;
            }
        }

        @Override
        public void onFailed(int what, Response response) {
            Log.e(TAG, "onFailed:----- " + response.get());
        }
    };

    LineChart[] mCharts; // 4条数据
    Typeface mTf; // 自定义显示字体
    int[] mColors = new int[]{Color.rgb(137, 230, 81), Color.rgb(240, 240, 30),//
            Color.rgb(89, 199, 250), Color.rgb(250, 104, 104)}; // 自定义颜色

    /**
     * 对获得的json进行解析
     *
     * @param statisticJson
     */
    private void parseStatisticData(String statisticJson) {
        try {
            JSONObject jsonObject = new JSONObject(statisticJson);
            JSONObject datas = jsonObject.getJSONObject("datas");
            JSONObject trendData = datas.getJSONObject("trendData");
            String statisType = datas.getString("statisType");
            trendData.getJSONArray("returnMoneyData");

            JSONArray returnMoneyData = trendData.getJSONArray("returnMoneyData");
            for (int i = 0; i < returnMoneyData.length(); i++) {
                Log.e(TAG, "parseStatisticData: -----" + i + "------" + returnMoneyData.get(i));
            }

            for (int i = 0; i < returnMoneyData.length(); i++) {
                int orderCount = returnMoneyData.getInt(i);
                yVals.add(new Entry((float) orderCount, i));
                xVals.add(i + "时");
            }
            dataSet = new LineDataSet(yVals, "公司年度利润");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            data = new LineData(xVals, dataSet);
            chart.setData(data);
            chart.setDescription("公司年度利润");
            chart.animateY(3000);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
