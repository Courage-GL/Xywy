package com.example.abner.xywy_net.bean;

import java.util.List;

/**
 * Created by 张萌 on 2017/6/12.
 */

public class ImageBean {


    /**
     * state : 200
     * email :
     * pushable : 1
     * avatar : http://xs3.op.xywy.com/api.iu1.xywy.com/ucenter/20170612/10fa597e933e5896db53e489e0bdf1a966770.jpg
     * accounts : [{"accountid":0,"accountstr":"会员116928090","sex":"女","height":"161","birthday":"1900-01-01"}]
     */

    private int state;
    private String email;
    private int pushable;
    private String avatar;
    private List<AccountsBean> accounts;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPushable() {
        return pushable;
    }

    public void setPushable(int pushable) {
        this.pushable = pushable;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<AccountsBean> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountsBean> accounts) {
        this.accounts = accounts;
    }

    public static class AccountsBean {
        /**
         * accountid : 0
         * accountstr : 会员116928090
         * sex : 女
         * height : 161
         * birthday : 1900-01-01
         */

        private int accountid;
        private String accountstr;
        private String sex;
        private String height;
        private String birthday;

        public int getAccountid() {
            return accountid;
        }

        public void setAccountid(int accountid) {
            this.accountid = accountid;
        }

        public String getAccountstr() {
            return accountstr;
        }

        public void setAccountstr(String accountstr) {
            this.accountstr = accountstr;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
