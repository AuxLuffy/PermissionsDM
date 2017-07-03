package com.lenovo.sunzh.permissionsdm.custom;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lenovo.sunzh.permissionsdm.MainActivity;
import com.lenovo.sunzh.permissionsdm.R;

public class Main2Activity extends Activity implements View.OnClickListener {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    private Button button;
    private EditText et;
    private int imeOption = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MainActivity.MIUISetStatusBarLightMode(getWindow(), true);
        doSth();
    }

    private void doSth() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        mHandler.sendMessage(obtain);
        et = (EditText) findViewById(R.id.et);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                imeOption++;
                et.setImeOptions(imeOption % 8);
                break;
        }
    }
}
