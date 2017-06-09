package com.example.abner.xywy_net.base;


import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.abner.xywy_net.App;

/**
 * Created by Abner on 2017/6/9.
 *
 */
public class FragmentBuilder {
    private BaseFragment baseFragment;
    private FragmentManager fragmentManager;
    private static FragmentBuilder fragmentBuilder;
    private String simpleName;
    private FragmentTransaction fragmentTransaction;

    private FragmentBuilder(BaseActivity baseActivity) {
        fragmentManager = baseActivity.getFragmentManager();
    }

    private void init() {
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    private FragmentBuilder(BaseFragment baseFragment1) {
        fragmentManager = baseFragment1.getFragmentManager();
    }

    public static FragmentBuilder getInstance(BaseActivity baseActivity) {


            fragmentBuilder = new FragmentBuilder(baseActivity);

        return fragmentBuilder;
    }

    public static FragmentBuilder getInstance(BaseFragment baseFragment1) {
        if (fragmentBuilder == null) {
            fragmentBuilder = new FragmentBuilder(baseFragment1);
        }
        return fragmentBuilder;
    }

    public FragmentBuilder startFragment(Class<? extends BaseFragment> classFragment) {
        init();
        simpleName = classFragment.getSimpleName();
        if (fragmentManager.findFragmentByTag(simpleName) == null) {
            try {
                baseFragment = classFragment.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {

            baseFragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
        }


        return this;
    }

    public FragmentBuilder addFragment(int viewID) {

        if (fragmentManager.findFragmentByTag(simpleName) == null) {
            fragmentTransaction.add(viewID, baseFragment, simpleName);
        }
        if (App.lastFragment != null) {
            fragmentTransaction.hide(App.lastFragment);
        }
        fragmentTransaction.show(baseFragment);
        App.lastFragment = baseFragment;

        return this;
    }

    public FragmentBuilder addBackStack() {
        fragmentTransaction.addToBackStack(simpleName);
        return this;
    }

    public FragmentBuilder recplace(int viewID) {
        fragmentTransaction.replace(viewID, baseFragment, simpleName);

        return this;
    }

    public FragmentBuilder builder() {
        if (fragmentTransaction == null) {
            new RuntimeException("请调用start()方法开启事物");
        }
        fragmentTransaction.commit();
//        fragmentTransaction = null;
        return this;
    }

    public static void nullFragmentManager() {
        FragmentManager fragmentManager = null;
    }
}
