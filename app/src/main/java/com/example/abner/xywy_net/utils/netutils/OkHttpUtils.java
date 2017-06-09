package com.example.abner.xywy_net.utils.netutils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Abner on 2017/6/9.
 */

public  class OkHttpUtils {
    private OkHttpClient client;
    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils(){

        client=new OkHttpClient();
    }

    public synchronized OkHttpUtils getInstance(){
        if (okHttpUtils==null){
            return okHttpUtils=new OkHttpUtils();
        }else {

            return okHttpUtils;
        }
    }

    public void get(String url, Map<String,String> map, final MyCallBack callBack){
        StringBuffer sb=null;
        if(url==null){
            return;
        }
        if(map!=null && map.size()>0){
            sb=new StringBuffer();
            sb.append("?");
            Set<String> keySet = map.keySet();
            for(String key:keySet){
                String value = map.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url=url+sb.toString().substring(0,sb.length()-1);
        }

        Request request=new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                callBack.OnError(getClass().getName()+"get"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                callBack.OnSuccess(result);
            }
        });
    }

    private void post(String url, Map<String,String> map, final MyCallBack callBack){
        if(url==null){
            return;
        }

        FormBody.Builder builder=new FormBody.Builder();
        if(map!=null && map.size()>0){
            Set<String> keySet = map.keySet();
            for(String key:keySet){
                String value=map.get(key);
                builder.add(key,value);
            }


        }
        final Request request=new Request.Builder().post(builder.build()).url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.OnError(getClass().getName()+"post"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                callBack.OnSuccess(result);
            }
        });

    }
}
