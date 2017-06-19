package com.example.abner.xywy_net.controller.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bumptech.glide.Glide;
import com.example.abner.xywy_net.App;
import com.example.abner.xywy_net.PullToRefreshRecycleView;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.adapter.DoctorAdapter;
import com.example.abner.xywy_net.base.BaseFragment;
import com.example.abner.xywy_net.controller.activity.AskDoctorActivity;
import com.example.abner.xywy_net.controller.activity.DcImagedetailOne;
import com.example.abner.xywy_net.controller.activity.DcImagedetailThree;
import com.example.abner.xywy_net.controller.activity.DcImagedetailTwo;
import com.example.abner.xywy_net.controller.activity.DcImagedetailfour;
import com.example.abner.xywy_net.controller.activity.DoctorActivity;
import com.example.abner.xywy_net.controller.activity.Findactivity;
import com.example.abner.xywy_net.controller.activity.MyPopupwindow;
import com.example.abner.xywy_net.controller.activity.zxm.CityActivity;
import com.example.abner.xywy_net.controller.activity.zxm.baidumap.LocationService;
import com.example.abner.xywy_net.entity.HotDcBean;
import com.example.abner.xywy_net.http.HttpCallBack;
import com.example.abner.xywy_net.http.RetrofitImpl;
import com.example.abner.xywy_net.params.Params;
import com.example.abner.xywy_net.utils.netutils.ForNet;

import java.util.HashMap;
import java.util.Map;

import static android.R.id.content;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by think on 2017/6/9.
 */

public class DoctorFragment extends BaseFragment implements View.OnClickListener{

    //百度地图定位
    private LocationService locationService;
    private ImageView  mine_location;
    private TextView  main_loc_meaage;
    private LinearLayout choose_city;

    private LinearLayout mlinearLayout;
    private RelativeLayout relativeLayout,search_edit_btn,re_hospital;
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private TextView textView1,textView2,textView3,textView4,textView_hospital,textView_teacher;
    private TextView huanyihuan;
    private int pageNum = 1;
    private Dialog dialog;
    private TextView search_text;
    private LinearLayout linearLayout_hot,not_net_hot,free_ask_dc_lin,good_people_lin;


    @Override
    protected int layoutId() {
        return R.layout.activity_sc_main;
    }

    @Override
    protected void initView(View view) {
        textView_teacher = (TextView) view.findViewById(R.id.textView_teacher);
        textView_hospital = (TextView) view.findViewById(R.id.textView_hospital);
        re_hospital = (RelativeLayout) view.findViewById(R.id.re_hospital);
        mine_location= (ImageView) view.findViewById(R.id.mine_location);
        main_loc_meaage = (TextView) view.findViewById(R.id.main_loc_meaage);
        choose_city= (LinearLayout) view.findViewById(R.id.choose_city);

        search_text = (TextView) view.findViewById(R.id.search_text);

        search_edit_btn = (RelativeLayout) view.findViewById(R.id.search_edit_btn);
        free_ask_dc_lin = (LinearLayout) view.findViewById(R.id.free_ask_dc);
        good_people_lin = (LinearLayout) view.findViewById(R.id.good_people);
        not_net_hot = (LinearLayout) view.findViewById(R.id.not_net);
        linearLayout_hot = (LinearLayout) view.findViewById(R.id.hot_doctor_lin);
        imageView1 = (ImageView) view.findViewById(R.id.image_line1);
        imageView2 = (ImageView) view.findViewById(R.id.image_line2);
        imageView3 = (ImageView) view.findViewById(R.id.image_line3);
        imageView4 = (ImageView) view.findViewById(R.id.image_line4);
        textView1 = (TextView) view.findViewById(R.id.text_line1);
        textView2 = (TextView) view.findViewById(R.id.text_line2);
        textView3 = (TextView) view.findViewById(R.id.text_line3);
        textView4 = (TextView) view.findViewById(R.id.text_line4);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
        mlinearLayout = (LinearLayout) view.findViewById(R.id.check_dc);
        huanyihuan = (TextView) view.findViewById(R.id.huanyihuan);
    }




    @Override
    protected void loadData() {

        if (ForNet.getNetState(getActivity()) == false) {
            Toast.makeText(getActivity(), "无网络连接", Toast.LENGTH_SHORT).show();
        } else {

            Map<String, String> map = new HashMap<>();
            map.put("tag", "BloodAndroid");
            map.put("sign", "2c19b2821ebc5306c3ac37bac5b4288b");
            map.put("act", "zhuanjia");
            map.put("fun", "HotDoctor");
            map.put("pageNum", pageNum + "");
            map.put("pageCount", "4");


            RetrofitImpl.getInstance().get(HotDcBean.class, Params.URL, map, new HttpCallBack() {


                private String app_image3;
                private String app_image2;
                private String app_image1;
                private String app_image;

                @Override
                public void onSuccessful(Object success) {

                    final HotDcBean dataBean = (HotDcBean) success;
                    final String name = dataBean.getData().get(0).getName();
                    String name1 = dataBean.getData().get(1).getName();
                    String name2 = dataBean.getData().get(2).getName();
                    String name3 = dataBean.getData().get(3).getName();

                    String menzhen = dataBean.getData().get(0).getMenzhen();

                    String substring = menzhen.substring(9,10);
                    String substringTime = menzhen.substring(4,6);
                    Log.d("DoctorFragment", substring);
                    Log.d("DoctorFragment", substringTime);

                    final String expert_id = dataBean.getData().get(0).getExpert_id();
                    final String expert_id1 = dataBean.getData().get(1).getExpert_id();
                    final String expert_id2 = dataBean.getData().get(2).getExpert_id();
                    final String expert_id3 = dataBean.getData().get(3).getExpert_id();

                    textView1.setText(name);
                    textView2.setText(name1);
                    textView3.setText(name2);
                    textView4.setText(name3);

                    app_image = dataBean.getData().get(0).getApp_image();
                    app_image1 = dataBean.getData().get(1).getApp_image();
                    app_image2 = dataBean.getData().get(2).getApp_image();
                    app_image3 = dataBean.getData().get(3).getApp_image();

                    Glide.with(getActivity()).load(app_image)
                            .placeholder(R.drawable.dc)
                            .into(imageView1);
                    imageView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                          Intent intent_image1 = new Intent(getActivity(), DcImagedetailOne.class);
                            intent_image1.putExtra("image", app_image);
                            intent_image1.putExtra("name", dataBean.getData().get(0).getName());
                            intent_image1.putExtra("hosptail", dataBean.getData().get(0).getHospital());
                            intent_image1.putExtra("title", dataBean.getData().get(0).getTitle());
                            intent_image1.putExtra("depart", dataBean.getData().get(0).getDepart());
                            intent_image1.putExtra("teach", dataBean.getData().get(0).getTeach());
                            intent_image1.putExtra("text", dataBean.getData().get(0).getGoodat());
                            intent_image1.putExtra("expert_id",expert_id);
                            startActivity(intent_image1);
                        }
                    });
                    Glide.with(getActivity()).load(app_image1).into(imageView2);
                    imageView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent_image2 = new Intent(getActivity(), DcImagedetailTwo.class);
                            intent_image2.putExtra("image", app_image1);
                            intent_image2.putExtra("name", dataBean.getData().get(1).getName());
                            intent_image2.putExtra("hosptail", dataBean.getData().get(1).getHospital());
                            intent_image2.putExtra("title", dataBean.getData().get(1).getTitle());
                            intent_image2.putExtra("depart", dataBean.getData().get(1).getDepart());
                            intent_image2.putExtra("teach", dataBean.getData().get(1).getTeach());
                            intent_image2.putExtra("text", dataBean.getData().get(1).getGoodat());
                            intent_image2.putExtra("expert_id1",expert_id1);
                            startActivity(intent_image2);
                        }
                    });
                    Glide.with(getActivity()).load(app_image2).into(imageView3);
                    imageView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent_image3 = new Intent(getActivity(), DcImagedetailThree.class);
                            intent_image3.putExtra("image", app_image2);
                            intent_image3.putExtra("name", dataBean.getData().get(2).getName());
                            intent_image3.putExtra("hosptail", dataBean.getData().get(2).getHospital());
                            intent_image3.putExtra("title", dataBean.getData().get(2).getTitle());
                            intent_image3.putExtra("depart", dataBean.getData().get(2).getDepart());
                            intent_image3.putExtra("teach", dataBean.getData().get(2).getTeach());
                            intent_image3.putExtra("text", dataBean.getData().get(2).getGoodat());
                            intent_image3.putExtra("expert_id2",expert_id2);
                            startActivity(intent_image3);
                        }
                    });

                    Glide.with(getActivity()).load(app_image3).into(imageView4);
                    imageView4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent_image4 = new Intent(getActivity(), DcImagedetailfour.class);
                            intent_image4.putExtra("image", app_image3);
                            intent_image4.putExtra("name", dataBean.getData().get(3).getName());
                            intent_image4.putExtra("hosptail", dataBean.getData().get(3).getHospital());
                            intent_image4.putExtra("title", dataBean.getData().get(3).getTitle());
                            intent_image4.putExtra("depart", dataBean.getData().get(3).getDepart());
                            intent_image4.putExtra("teach", dataBean.getData().get(3).getTeach());
                            intent_image4.putExtra("text", dataBean.getData().get(3).getGoodat());
                            intent_image4.putExtra("expert_id3",expert_id3);
                            startActivity(intent_image4);

                        }
                    });


                    //显示
                    linearLayout_hot.setVisibility(View.VISIBLE);
                    SharedPreferences sp = getActivity().getSharedPreferences("findkey",MODE_PRIVATE);
                    String content = sp.getString("content", "");

                    if(content != null){
                        search_text.setText(content);
                        sp.edit().clear();
                    }

                }

                @Override
                public void onError(String errorMessage) {

                }
            });
        }
    }


    @Override
    protected void initListener() {
        re_hospital.setOnClickListener(this);
        free_ask_dc_lin.setOnClickListener(this);
        good_people_lin.setOnClickListener(this);
        mlinearLayout.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
        huanyihuan.setOnClickListener(this);
        mine_location.setOnClickListener(this);
        choose_city.setOnClickListener(this);
        search_edit_btn.setOnClickListener(this);
    }


    //健康顾问
    private void showPhoneDialog(){

        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.isloc,null);
        dialog=new AlertDialog.Builder(getActivity()).setView(view2).create();
        TextView text = (TextView) view2.findViewById(R.id.text);
        text.setText("您是否要拨打寻医问药的健康电话：400-900-120");
        LinearLayout lin_ok = (LinearLayout) view2.findViewById(R.id.okloc);
        LinearLayout lin_cancel = (LinearLayout) view2.findViewById(R.id.cancelloc);
        lin_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        lin_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:400-9700-120"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                dialog.dismiss();
            }
        });
            dialog.show();
    }



        //医院等级
        private void showListDialog() {
            final String[] items = { "不限","三级甲等","三级乙等","三级丙等","三级","二级甲等","二级乙等","二级丙等" };
            AlertDialog.Builder listDialog =
                    new AlertDialog.Builder(getActivity());
            listDialog.setTitle("医院等级");
            listDialog.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    String item = items[which];
                    Toast.makeText(getActivity(),
                            "你点击了" + items[which],
                            Toast.LENGTH_SHORT).show();
                    textView_hospital.setText(item);

                }
            });
            listDialog.show();
        }


    //医院职称
    private void showListDialog2() {

        final String[] items = { "不限","主任医师","副主任医师","主任医师","医师" };
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(getActivity());
        listDialog.setTitle("医院职称");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                String item = items[which];
                Toast.makeText(getActivity(),
                        "你点击了" + items[which],
                        Toast.LENGTH_SHORT).show();
                textView_teacher.setText(item);

            }
        });
        listDialog.show();
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //关键字查询
            case R.id.search_edit_btn:
                Intent intentseaech = new Intent(getActivity(), Findactivity.class);
                startActivity(intentseaech);
                break;
            //查询专家
            case R.id.check_dc:
                Intent intent_dc = new Intent(getActivity(), PullToRefreshRecycleView.class);
                startActivity(intent_dc);
                break;
            //医院等级
            case R.id.relativeLayout:
                showListDialog();
                break;
            //换一换
            case R.id.huanyihuan:
                pageNum++;
                loadData();
                break;
            //免费问医生
            case R.id.free_ask_dc:
                Intent intentfree = new Intent(getActivity(), AskDoctorActivity.class);
                startActivity(intentfree);
                break;
            //健康顾问
            case R.id.good_people:
                showPhoneDialog();
                break;
            //定位
            case R.id.mine_location:
                showCustomizeDialog();
                break;
            //选择城市
            case R.id.choose_city:
                Intent  intent=new Intent(getActivity(), CityActivity.class);
                startActivityForResult(intent,200);
                break;
            //医院职称
            case R.id.re_hospital:
                showListDialog2();
                break;
        }
    }




    /***
     * 以下是百度地图定位以及城市选择省份,如果有冲突可以说明改正
     * 张晓萌
     */

    /**
     * 显示请求字符串
     *
     * @param str
     */
    public void logMsg(String str) {
        final String s = str;
        try {
            if (main_loc_meaage != null){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        main_loc_meaage.post(new Runnable() {
                            @Override
                            public void run() {
                                main_loc_meaage.setText(s);
                            }
                        });

                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /***
     * Stop location service
     */
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // -----------location config ------------
        locationService = ((App) getActivity().getApplication()).locationService;
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getActivity().getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
    }


    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                String city = location.getCity();
                logMsg(city);
            }
        }

        public void onConnectHotSpotMessage(String s, int i){
        }
    };



    //<----------是否选择定位,-------------------------------->

    private void showCustomizeDialog() {
    /* @setView 装入自定义View ==> R.layout.dialog_customize
     * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
     * dialog_customize.xml可自定义更复杂的View
     */
        final View dialogView = LayoutInflater.from(getActivity())
                .inflate(R.layout.isloc,null);
        final AlertDialog   customizeDialog =
                new AlertDialog.Builder(getActivity()).setView(dialogView).create();
        LinearLayout  ok= (LinearLayout) dialogView.findViewById(R.id.okloc);
        LinearLayout  cancelloc= (LinearLayout) dialogView.findViewById(R.id.cancelloc);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationService.start();// 定位SDK
                customizeDialog.dismiss();
                Toast.makeText(getActivity(), "定位成功", Toast.LENGTH_SHORT).show();
            }
        });
        cancelloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customizeDialog.dismiss();
                Toast.makeText(getActivity(), "取消定位", Toast.LENGTH_SHORT).show();
            }
        });

        customizeDialog.show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200&&resultCode==100){
            String s = data.getStringExtra("s");
            main_loc_meaage.setText(s);
        }
    }
}

