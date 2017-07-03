package com.lenovo.sunzh.permissionsdm.custom;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import com.lenovo.sunzh.permissionsdm.MainActivity;
import com.lenovo.sunzh.permissionsdm.R;

public class Main2Activity extends Activity {

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MainActivity.MIUISetStatusBarLightMode(getWindow(),true);
        doSth();
    }

    private void doSth() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        mHandler.sendMessage(obtain);
        button = (Button) findViewById(R.id.button);
    }

}
