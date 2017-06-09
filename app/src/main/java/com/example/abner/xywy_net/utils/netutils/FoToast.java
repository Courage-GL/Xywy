package com.example.abner.xywy_net.utils.netutils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @author linmu
 */
public class FoToast
{

    /**
     * toast
     */
    public static void toast(Context context, int resid)
    {
        Toast toast = Toast.makeText(context, resid, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * toast
     */
    public static void toast(Context context, String info)
    {
        Toast toast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
