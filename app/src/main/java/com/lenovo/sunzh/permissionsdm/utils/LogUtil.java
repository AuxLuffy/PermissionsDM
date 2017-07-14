package com.lenovo.sunzh.permissionsdm.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Log工具类
 * Created by sunzh on 2017/7/11.
 */

public class LogUtil {
    private static String customTagPrefix = "Luffy";
    private static boolean isDebug = true;

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setIsDebug(boolean isDebug) {
        LogUtil.isDebug = isDebug;
    }

    /**
     * 产生tag: 格式：[customTagPrefix:]classNamme.methodName(L:lineNumber)
     */
    public static String generateTag() {
        /**
         07-11 16:18:04.121 18398-18398/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.utils.LogUtil; methodName: generateTag; fileName: LogUtil.java
         07-11 16:18:04.121 18398-18398/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.custom.Main2Activity; methodName: testLog; fileName: Main2Activity.java
         07-11 16:18:04.121 18398-18398/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.custom.Main2Activity; methodName: onClick; fileName: Main2Activity.java
         */
//        StackTraceElement[] arr = new Exception().getStackTrace();
        /**
         07-11 16:16:16.298 15768-15768/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.utils.LogUtil; methodName: generateTag; fileName: LogUtil.java
         07-11 16:16:16.298 15768-15768/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.custom.Main2Activity; methodName: testLog; fileName: Main2Activity.java
         07-11 16:16:16.298 15768-15768/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.custom.Main2Activity; methodName: onClick; fileName: Main2Activity.java
         */
        StackTraceElement[] arr = new Throwable().getStackTrace();
        /**
         07-11 16:33:58.425 2661-2661/com.lenovo.sunzh.permissionsdm E/LogUtil: className: dalvik.system.VMStack; methodName: getThreadStackTrace; fileName: VMStack.java
         07-11 16:33:58.425 2661-2661/com.lenovo.sunzh.permissionsdm E/LogUtil: className: java.lang.Thread; methodName: getStackTrace; fileName: Thread.java
         07-11 16:33:58.425 2661-2661/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.utils.LogUtil; methodName: generateTag; fileName: LogUtil.java
         07-11 16:33:58.425 2661-2661/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.custom.Main2Activity; methodName: testLog; fileName: Main2Activity.java
         07-11 16:33:58.425 2661-2661/com.lenovo.sunzh.permissionsdm E/LogUtil: className: com.lenovo.sunzh.permissionsdm.custom.Main2Activity; methodName: onClick; fileName: Main2Activity.java
         */
        //比上一层多了VMStack.getThreadStackTrace和Thread:getStackTrace这两层，当用Thread的方法获取时用arr[2]以后的，用Exception或Throwable获方法域时用arr[0]以后的 
//        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
//        for (int i = 0; i < arr.length; i++) {
//            Log.e("LogUtil", "className: " + arr[i].getClassName() + "; methodName: " + arr[i].getMethodName() + "; fileName: " + arr[i].getFileName());
//        }
        String tag = "%s.%s(L:%d)";
        StackTraceElement caller = arr[2];
        String callerClassName = caller.getClassName();
        callerClassName = callerClassName.substring(callerClassName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClassName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    public static void d(String content) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.d(tag, content);
    }

    public static void d(String content, Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.d(tag, content, tr);
    }

    public static void e(String content) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.e(tag, content);
    }

    public static void e(String content, Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.e(tag, content, tr);
    }

    public static void i(String content) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.i(tag, content);
    }

    public static void i(String content, Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.i(tag, content, tr);
    }

    public static void v(String content) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.v(tag, content);
    }

    public static void v(String content, Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.v(tag, content, tr);
    }

    public static void w(String content) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.w(tag, content);
    }

    public static void w(String content, Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.w(tag, content, tr);
    }

    public static void w(Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.w(tag, tr);
    }


    public static void wtf(String content) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.wtf(tag, content);
    }

    public static void wtf(String content, Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.wtf(tag, content, tr);
    }

    public static void wtf(Throwable tr) {
        if (isDebug()) return;
        String tag = generateTag();

        Log.wtf(tag, tr);
    }

}
