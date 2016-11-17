package com.text.dukang.knowheartmusic.model;

import java.util.List;

/**
 * Created by wdk on 2016/11/17.
 * 功能介绍：登录界面的实体
 */

public class LoginData {

    /**
     * code : 200
     * datas : {"is_login":"1","member_id":"288","chain_member_name":"fengqinglu","appkey":"0d3c7beae171cf4685aef7e013297d15","is_buy":"1","chain_id":"233","store_id":null,"account_key":"YXWLm","seller_is_admin":1,"seller_limits":[""],"seller_group_id":"0","seller_gc_limits":null,"seller_group_name":"管理员","seller_smt_limits":false}
     */

    private int code;
    /**
     * is_login : 1
     * member_id : 288
     * chain_member_name : fengqinglu
     * appkey : 0d3c7beae171cf4685aef7e013297d15
     * is_buy : 1
     * chain_id : 233
     * store_id : null
     * account_key : YXWLm
     * seller_is_admin : 1
     * seller_limits : [""]
     * seller_group_id : 0
     * seller_gc_limits : null
     * seller_group_name : 管理员
     * seller_smt_limits : false
     */

    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public  class DatasBean {
        private String is_login;
        private String member_id;
        private String chain_member_name;
        private String appkey;
        private String is_buy;
        private String chain_id;
        private Object store_id;
        private String account_key;
        private int seller_is_admin;
        private String seller_group_id;
        private Object seller_gc_limits;
        private String seller_group_name;
        private boolean seller_smt_limits;
        private List<String> seller_limits;

        public String getIs_login() {
            return is_login;
        }

        public void setIs_login(String is_login) {
            this.is_login = is_login;
        }

        public String getMember_id() {
            return member_id;
        }

        public void setMember_id(String member_id) {
            this.member_id = member_id;
        }

        public String getChain_member_name() {
            return chain_member_name;
        }

        public void setChain_member_name(String chain_member_name) {
            this.chain_member_name = chain_member_name;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getIs_buy() {
            return is_buy;
        }

        public void setIs_buy(String is_buy) {
            this.is_buy = is_buy;
        }

        public String getChain_id() {
            return chain_id;
        }

        public void setChain_id(String chain_id) {
            this.chain_id = chain_id;
        }

        public Object getStore_id() {
            return store_id;
        }

        public void setStore_id(Object store_id) {
            this.store_id = store_id;
        }

        public String getAccount_key() {
            return account_key;
        }

        public void setAccount_key(String account_key) {
            this.account_key = account_key;
        }

        public int getSeller_is_admin() {
            return seller_is_admin;
        }

        public void setSeller_is_admin(int seller_is_admin) {
            this.seller_is_admin = seller_is_admin;
        }

        public String getSeller_group_id() {
            return seller_group_id;
        }

        public void setSeller_group_id(String seller_group_id) {
            this.seller_group_id = seller_group_id;
        }

        public Object getSeller_gc_limits() {
            return seller_gc_limits;
        }

        public void setSeller_gc_limits(Object seller_gc_limits) {
            this.seller_gc_limits = seller_gc_limits;
        }

        public String getSeller_group_name() {
            return seller_group_name;
        }

        public void setSeller_group_name(String seller_group_name) {
            this.seller_group_name = seller_group_name;
        }

        public boolean isSeller_smt_limits() {
            return seller_smt_limits;
        }

        public void setSeller_smt_limits(boolean seller_smt_limits) {
            this.seller_smt_limits = seller_smt_limits;
        }

        public List<String> getSeller_limits() {
            return seller_limits;
        }

        public void setSeller_limits(List<String> seller_limits) {
            this.seller_limits = seller_limits;
        }
    }
}
