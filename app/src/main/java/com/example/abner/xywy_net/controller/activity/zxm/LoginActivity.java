package com.example.abner.xywy_net.controller.activity.zxm;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abner.xywy_net.App;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.bean.ImageBean;
import com.example.abner.xywy_net.bean.LoginBean;
import com.example.abner.xywy_net.utils.netutils.MyCallBack;
import com.example.abner.xywy_net.utils.netutils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.abner.xywy_net.R.id.aboutthis;
import static com.example.abner.xywy_net.R.id.forgetpassword;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class LoginActivity  extends BaseActivity {
    Button  login;
    TextView  forget;
    EditText  phone,password;
    SharedPreferences  share;
 SharedPreferences.Editor  editor;
    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView()  {
        login= (Button) findViewById(R.id.login_button);
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
      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(TextUtils.isEmpty(phone.getText().toString())||TextUtils.isEmpty(password.getText().toString())){
                  Toast.makeText(LoginActivity.this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
              }
              share=getSharedPreferences("logindata",MODE_PRIVATE);
               editor=share.edit();
              OkHttpUtils  ok=new OkHttpUtils();
              Map<String,String>  map=new HashMap<String, String>();
              map.put("phonenum",phone.getText().toString());
              map.put("password",password.getText().toString());
              ok.getInstance().post("http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=kbb&fun=users&type=login", map, new MyCallBack() {
                  @Override
                  public void OnSuccess(String result) {
                      Log.i("--logindata",result);
                      Gson  gson=new Gson();
                      LoginBean loginBean = gson.fromJson(result, LoginBean.class);
                      int state = loginBean.getState();
                      if(state==200) {
                          App.activity.runOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  Toast.makeText(LoginActivity.this, "您输入的密码或账号有误", Toast.LENGTH_SHORT).show();
                              }
                          });
                          String birthday = loginBean.getBirthday();
                          int height = loginBean.getHeight();
                          String phonenum = loginBean.getPhonenum();
                          String sex = loginBean.getSex();
                          final String userid = loginBean.getUserid();

                          editor.putBoolean("islogin",true);
                          editor.putString("birthday",birthday);
                          editor.putInt("height",height);
                          editor.putString("phonenum",phonenum);
                          editor.putString("sex",sex);
                          editor.putString("userid",userid);
                          editor.commit();

                          new  Thread(new Runnable() {
                              @Override
                              public void run() {
                                  getImage(userid);
                              }
                          }).start();



                      }

                  }

                  @Override
                  public void OnError(String errorMsg) {

                  }
              });

          }
      });
    }


    String baseurl="http://api.wws.xywy.com/index.php?act=kbb&fun=users&type=pullAccountInfo&tag=wjk&";
    String  url="userid=116928090&sign=ee3dd4651821d3a45f4329a86d459cb7";

    private void getImage(String  userid){
        StringBuffer  sb=new StringBuffer();
         sb.append(baseurl).append("userid=").append(userid).append("&sign=ee3dd4651821d3a45f4329a86d459cb7");
        OkHttpClient  okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(sb.toString()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 String  str=response.body().string();
                Log.i("login",str);
                Gson  gson=new Gson();
                ImageBean imageBean = gson.fromJson(str, ImageBean.class);
                String avatar = imageBean.getAvatar();
                editor.putString("avatar",avatar);
                editor.commit();
                finish();
            }
        });
    }




}
