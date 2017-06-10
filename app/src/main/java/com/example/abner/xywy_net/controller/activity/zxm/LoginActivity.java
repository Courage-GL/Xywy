package com.example.abner.xywy_net.controller.activity.zxm;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

import static com.example.abner.xywy_net.R.id.forgetpassword;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class LoginActivity  extends BaseActivity {
    Button  login;
    TextView  forget;
    EditText  phone,password;
    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView()  {
        login= (Button) findViewById(R.id.login_btn);
        forget= (TextView) findViewById(forgetpassword);
        phone= (EditText) findViewById(R.id.logon_phone);
        password= (EditText) findViewById(R.id.login_password);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }
}
