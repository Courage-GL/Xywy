package com.example.abner.xywy_net.utils.netutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.abner.xywy_net.R;

/**
 * 检测当前网络状态,无网络返回false,又网络返回true;
 */
public class ForNet
{
    //

    public static boolean getNetState(Context ctx)
    {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        if (info == null)
        {
            FoToast.toast(ctx, "请检查网络连接");
            return false;
        }
        else
        {
            return true;
        }
    }
}
