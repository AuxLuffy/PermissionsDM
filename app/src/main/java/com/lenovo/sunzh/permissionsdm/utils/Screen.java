package com.lenovo.sunzh.permissionsdm.utils;

import android.app.Activity;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * 常用概念：
 *      全屏模式
 *      着色模式
 *      contentview：即setContentView所设置的View，实质为Framelayout
 *      contentParent：contentview的parent，实质为linearLayout
 *      childview: contentView的第一个子view即布局文件中的layout
 * 相关函数：
 *      fitSystemWindows，该属性可以设置是否为系统View预留空间，当设置为true时，会预留出状态栏的空间
 *      contentview，实质为contentframelayout，但是重写了dispatchFitSystemWindows方法，所以其设置fitSystemWindows无效
 *      contentParent,实质为fitwindowslinearlayout,里面每一个view是viewstubcompact，如果主题没有title，它就不会inflate.第二个view就是contentview
 * 屏幕透明状态栏工具类
 * Created by sunzh on 2017/10/13.
 */

public class Screen {
    /**
     * @param activity 上下文
     * @param statusColor 状态栏颜色
     */
    public static void transluentBar(Activity activity, int statusColor) {
        Window window = activity.getWindow();
        ViewGroup mContentView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个flag才能调用setstatusbarcolor设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置颜色
            window.setStatusBarColor(statusColor);
            if (mChildView != null) {
                //注意不是设置ContentView的FitSystemWindows,而是设置ContentView的子view,使其不为系统View预留空间
                ViewCompat.setFitsSystemWindows(mChildView, false);
            }
        }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //首先使childview不预留空间
            if(mChildView!=null) {
                ViewCompat.setFitsSystemWindows(mChildView, false);
            }
            int statusBarHeight = WindowUtils.getStatusBarHeight(activity);
            //需要设置这个flag才能设置状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            if(mChildView != null) {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mChildView.getLayoutParams();
                if(lp != null && lp.topMargin >= statusBarHeight) {
                    lp.topMargin -= statusBarHeight;
                    mChildView.setLayoutParams(lp);
                }
            }
        }
    }
}
