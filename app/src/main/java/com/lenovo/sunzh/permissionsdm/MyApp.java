package com.lenovo.sunzh.permissionsdm;

import android.app.Application;

import com.lenovo.sunzh.permissionsdm.utils.ToastUtil;

/**
 * Created by sunzh on 2017/7/4.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.initContext(this);
    }
}
