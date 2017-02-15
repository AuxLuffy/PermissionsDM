package com.lenovo.sunzh.permissionsdm;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 权限工具类
 * @author: 袁东华
 * created at 2016/11/24 14:31
 */
public class PermissionsUtil {
    private final int REQUEST_CODE_ASK_PERMISSIONS = 100;
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    /**
     * @description: 请求操作sd卡权限
     * @author:袁东华 created at 2016/10/4 19:32
     */
    public boolean requestStorage(Activity activity) {
        if (afterM()) {
            int hasPermission = activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return false;
            }
        }
        return true;
    }

    /**
     * @description: 获取语音权限
     * @author: 袁东华
     * created at 2016/11/24 14:36
     */
    public boolean requestAudio(Activity activity) {
        if (afterM()) {
            int hasPermission = activity.checkSelfPermission(Manifest.permission.RECORD_AUDIO);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return false;
            }
        }
        return true;
    }

    /**
     * @description: 获取视频权限
     * @author: 袁东华
     * created at 2016/11/24 14:36
     */
    public boolean requestVideo(Activity activity) {
        if (afterM()) {
            final List<String> permissionsList = new ArrayList<>();
            if ((activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED))
                permissionsList.add(Manifest.permission.CAMERA);
            if ((activity.checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED))
                permissionsList.add(Manifest.permission.RECORD_AUDIO);
            if (permissionsList.size() != 0) {
                activity.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_PERMISSIONS);
                return false;
            }
            int hasPermission = activity.checkSelfPermission(Manifest.permission.CAMERA);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return false;
            }
        }
        return true;
    }

    /**
     * @description: 请求相机权限
     * @author:袁东华 created at 2016/10/4 19:30
     */
    public boolean requestCamera(Activity activity) {
        if (afterM()) {
            int hasPermission = activity.checkSelfPermission(Manifest.permission.CAMERA);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return false;
            }
        }
        return true;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public boolean requestCamera1(Activity activity) {
        if (afterM()) {
            int i = activity.getPackageManager().checkPermission(Manifest.permission.CAMERA, activity.getPackageName());
            if (i != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA}, 0);
                return false;
            }
        }
        return true;
    }

    /**
     * @description: 比较版本
     * @author:袁东华 created at 2016/10/4 19:30
     */
    private boolean afterM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    private static PermissionsUtil instance;

    private PermissionsUtil() {
    }

    public static PermissionsUtil getInstance() {
        if (instance == null) {
            synchronized (PermissionsUtil.class) {
                if (instance == null) {
                    instance = new PermissionsUtil();
                }
            }
        }
        return instance;
    }
}
