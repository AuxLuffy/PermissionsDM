package com.lenovo.sunzh.permissionsdm;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.lenovo.sunzh.permissionsdm.custom.Main2Activity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends Activity {
    private static final int REQUEST_PERMISSION = 0;
    private static final String PACKAGE_URL_SCHEME = "package:";
    public static final int PERMISSIONS_GRANTED = 0; // 权限授权
    public static final int PERMISSIONS_DENIED = 1; // 权限拒绝
    public Button btCheck;

    /**
     * 设置状态栏图标为深色和魅族特定的文字风格
     * 可以用来判断是否为Flyme用户
     * @param window 需要设置的窗口
     * @param dark 是否把状态栏字体及图标颜色设置为深色
     * @return  boolean 成功执行返回true
     *
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }
    /**
     * 设置状态栏字体图标为深色，需要MIUIV6以上
     * @param window 需要设置的窗口
     * @param dark 是否把状态栏字体及图标颜色设置为深色
     * @return  boolean 成功执行返回true
     *
     */
    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if(dark){
                    extraFlagField.invoke(window,darkModeFlag,darkModeFlag);//状态栏透明且黑色字体
                }else{
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result=true;
            }catch (Exception e){

            }
        }
        return result;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        requestPermission();
        MIUISetStatusBarLightMode(getWindow(),true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        btCheck = (Button) findViewById(R.id.bt_check);
        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 第二次上传
                /*int integer = getResources().getInteger(R.integer.integer);
                float fraction = getResources().getFraction(R.fraction.percent, 1, 1);
                int[] intArray = getResources().getIntArray(R.array.integerarr);
                Toast.makeText(MainActivity.this, "取到的数组为:" + Arrays.toString(intArray), Toast.LENGTH_SHORT).show();
                List<int[]> ints = Arrays.asList(intArray);*/
//                Toast.makeText(MainActivity.this, "取到的数为" + integer, Toast.LENGTH_SHORT).show();
//                float dimension = getResources().getDimension(R.dimen.dicemlevalue);
//                Toast.makeText(MainActivity.this, "取到的小数为：" + fraction, Toast.LENGTH_SHORT).show();
//                Spanned abc = Html.fromHtml("abc");

                MainActivityPermissionsDispatcher.gotonextWithCheck(MainActivity.this);
            }
        });
    }
    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS})
    void gotonext() {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
    }

    /**
     * 检查相机权限
     */
    public boolean cameraIsCanUse() {
        boolean isCanUse = true;
        Camera mCamera = null;
        //try {
        mCamera = Camera.open();
        Camera.Parameters mParameters = mCamera.getParameters(); //针对魅族手机
        mCamera.setParameters(mParameters);
        /*} catch (Exception e) {
            isCanUse = false;
        }*/

        if (mCamera != null) {
            try {
                mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                return isCanUse;
            }
        }
        return isCanUse;
    }

    @TargetApi(23)
    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            // 定位精确位置
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.CAMERA);
            }
            if (permissions.size() > 0) {
                String atestt[] = new String[permissions.size()];
                permissions.toArray(atestt);
                requestPermissions(atestt, REQUEST_PERMISSION);
            } else {
                //cameraIsCanUse();
                //Utils.openLocationService(this);
                //PushManager.getInstance().initialize(this.getApplicationContext());
            }
        } else {
            // Utils.openLocationService(this);
            //PushManager.getInstance().initialize(this.getApplicationContext());
        }
    }

}
