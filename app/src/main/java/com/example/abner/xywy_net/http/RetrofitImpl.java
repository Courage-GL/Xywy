package com.example.abner.xywy_net.http;

import android.support.annotation.NonNull;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RetrofitImpl implements IHttp {

    private static RetrofitImpl retrofitImpl;
    //这个用来判断最后返回值为集合还是对象
    private boolean aBoolean;
    private Retrofit retrofit;
    private IRetrofit iRetrofit;


    //单例模式 只有一个Retrofit对象
    private RetrofitImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .build();
        iRetrofit = retrofit.create(IRetrofit.class);
    }

    public static RetrofitImpl getInstance() {
        if (retrofitImpl == null) {
            retrofitImpl = new RetrofitImpl();
        }
        return retrofitImpl;
    }

    //调用这个方法 最后网络请求返回的是一个集合
    public RetrofitImpl jsonList() {
        aBoolean = true;
        return this;
    }

    @Override
    public void get(final Class classDemo, String url, Map<String, String> map, final HttpCallBack httpCallBack) {
        map = getStringStringMap(map);
        Call<ResponseBody> call = iRetrofit.get(url, map);
        initInter(classDemo, httpCallBack, call);
    }


    @Override
    public void Post(Class classDemo, String url, Map<String, String> map, HttpCallBack httpCallBack) {
        map = getStringStringMap(map);
        Call<ResponseBody> call = iRetrofit.post(url, map);
        initInter(classDemo, httpCallBack, call);
    }

    private void initInter(final Class classDemo, final HttpCallBack httpCallBack, Call<ResponseBody> call) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //判断请求值是否成功
                if (response.isSuccessful()) {

                    String str = null;
                    try {
                        str = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                        //不成功抛出一个异常
                      //  throw new ConfigException("转为String字符串失败了 请查看网络地址或者网络端口");
                    }
                    //判断返回值是对象还是集合
                    if (!aBoolean) {
                        httpCallBack.onSuccessful(GsonUtils.gsonBean(str, classDemo));
                    } else {
                        httpCallBack.onSuccessful(GsonUtils.gsonList(str, classDemo));
                        aBoolean = false;
                    }
                } else {
                    try {
                        //失败调用失败接口
                        httpCallBack.onError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //失败调用失败接口
                httpCallBack.onError(t.getMessage());
            }
        });
        //初始化aBoolean以便下次使用

    }

    @NonNull
    private Map<String, String> getStringStringMap(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }







    public void login(final Class classDemo, String url, Map<String, String> map, final HttpCallBack httpCallBack) {
        Call<ResponseBody> login = iRetrofit.login(url, map);
        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    savecooike(response);
                    String str = null;
                    try {
                        str = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    httpCallBack.onSuccessful(GsonUtils.gsonBean(str, classDemo));
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                httpCallBack.onError(t.getMessage());
            }
        });

    }

    private static void savecooike(Response<ResponseBody> response) {
        String cookie = "";
        Headers headers = response.headers();
        Set<String> names = headers.names();
        for (String name : names) {
            String key = name;
//            List<String> values = headers.values(key);
            String values = headers.get(key);

            if (key.contains("Set-Cookie"))
                cookie += values + ";";
        }

        if (cookie.length() > 0) {
            cookie = cookie.substring(0, cookie.length() - 1);
        }
     //    App.sharedPreferences.edit().putString(KeyUtils.COOKIE,cookie).commit();
    }



}
