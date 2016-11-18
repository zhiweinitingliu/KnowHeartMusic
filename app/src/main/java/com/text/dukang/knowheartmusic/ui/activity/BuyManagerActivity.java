package com.text.dukang.knowheartmusic.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.ui.base.BaseActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wdk on 2016/11/18.
 * 功能介绍：采购管理
 */

public class BuyManagerActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    protected void setContent(Bundle savedInstanceState) {
        setContentView(R.layout.activity_buy_manager);
    }

    @Override
    protected void initView() {
        imageView= (ImageView) findViewById(R.id.imageview);
    }

    @Override
    protected void initData() {
        String url="http://ceshi.jybd.cn/member/index.php?act=seccode&op=makecode&nchash=9b69e2cf";
        Glide
                .with(this)
                .load(url)
                .into(imageView);


    }

    // 显示网络上的图片
    public static Bitmap returnBitMap(String url) {
        Log.i("returnBitMap","url="+url);
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
