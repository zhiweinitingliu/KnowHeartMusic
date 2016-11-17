package com.text.dukang.knowheartmusic.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSONObject;
import com.text.dukang.knowheartmusic.R;
import com.text.dukang.knowheartmusic.model.LoginData;
import com.text.dukang.knowheartmusic.ui.base.BaseActivity;
import com.text.dukang.knowheartmusic.util.SpUtil;
import com.text.dukang.knowheartmusic.util.StatusBarUtil;
import com.text.dukang.knowheartmusic.util.nohttp.CallServer;
import com.text.dukang.knowheartmusic.util.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
 * Created by wdk on 2016/11/17.
 * 功能介绍：登录界面
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";

    private EditText user_name;
    private EditText user_pwd;
    private AppCompatButton btn_login;
    private CallServer callServer;
    private SharedPreferences sharedPreferences;

    @Override
    protected void setContent(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        user_name = (EditText) findViewById(R.id.user_name);
        user_pwd = (EditText) findViewById(R.id.user_pwd);
        btn_login = (AppCompatButton) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        sharedPreferences = SpUtil.getSp(context);
        String userName = sharedPreferences.getString("userName", "");
        String userPwd = sharedPreferences.getString("userPwd", "");

        if (userName != null && userName.length() > 0) {//如果sp中存有用户名密码就直接显示
            user_name.setText(userName);

            if (userPwd != null && userPwd.length() > 0) {
                user_pwd.setText(userPwd);
            }
        }
    }

    @Override
    public void setStatusBarColor() {
        super.setStatusBarColor();
        mStatusBarColor = getResources().getColor(R.color.rgb_228_063_063);
        StatusBarUtil.setColor(context, mStatusBarColor, alpha_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login://点击登录按钮
                //开始登录
                userLogin();
                break;
        }
    }

    private void userLogin() {
        btn_login.setClickable(false);//设置按钮不能点击
        btn_login.setPressed(true);//设置按钮的状态为按下

        if (sharedPreferences == null) {
            sharedPreferences = SpUtil.getSp(context);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("userName", user_name.getText().toString());
        edit.putString("userPwd", user_pwd.getText().toString());
        edit.commit();

        callServer = CallServer.getRequestInstance();
        String url = "http://ceshi.jybd.cn/chainsell/index.php?act=login&op=dologin";
        Request request = NoHttp.createStringRequest(url, RequestMethod.POST);
        request.add("user", "fengqinglu");
        request.add("pwd", "123456");
        request.add("client", "android");

        callServer.add(context, 101, request, dataCallBack, false, false);
    }

    HttpListener dataCallBack = new HttpListener() {
        @Override
        public void onSucceed(int what, Response response) {
            switch (what) {
                case 101://登录接口请求数据成功
                    parseLoginJson(response.get().toString());
                    break;
            }

            Log.e(TAG, "onSucceed: tongji--data:::" + response.get().toString());
        }

        @Override
        public void onFailed(int what, Response response) {

        }
    };

    /**
     * 解析登录后服务器返回的json
     *
     * @param loginJson 登录服务器返回的json
     */
    private void parseLoginJson(String loginJson) {

        LoginData loginData = JSONObject.parseObject(loginJson, LoginData.class);

        int dataCode = loginData.getCode();
        if (dataCode == 400) {//登录失败

        } else if (dataCode == 200) {//登录成功
            if (sharedPreferences == null) {
                sharedPreferences = SpUtil.getSp(context);
            }
            sharedPreferences.edit().putString("appkey", loginData.getDatas().getAppkey()).commit();


            Intent intentMainActivity = new Intent(context, MainActivity.class);
            startActivity(intentMainActivity);
            finish();
        }


    }
}
