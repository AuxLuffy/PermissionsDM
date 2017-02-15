package com.lenovo.sunzh.permissionsdm;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lenovo.sunzh.permissionsdm.custom.Main2Activity;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final int REQUEST_PERMISSION = 0;
    private static final String PACKAGE_URL_SCHEME = "package:";
    public static final int PERMISSIONS_GRANTED = 0; // 权限授权
    public static final int PERMISSIONS_DENIED = 1; // 权限拒绝
    public Button btCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
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

                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    /**
     * @TargetApi(23)是指在6.0以上才自行，如果6.0一下，如果在Manifest中注册了，会自己自行，当然也没有必要再执行这个函数了
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

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION) {
            if ((grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                //PushManager.getInstance().initialize(this.getApplicationContext());
                //  Utils.openLocationService(this);
                // cameraIsCanUse();
            } else {
                //requestPermission();
            }
        }
    }
}
