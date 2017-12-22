package com.lenovo.sunzh.permissionsdm.custom;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.sunzh.permissionsdm.MainActivity;
import com.lenovo.sunzh.permissionsdm.R;
import com.lenovo.sunzh.permissionsdm.utils.KeyboardUtil;
import com.lenovo.sunzh.permissionsdm.utils.LogUtil;
import com.lenovo.sunzh.permissionsdm.utils.ToastUtil;

/**
 * 有EditText的话，进入的时候就会弹出输入法
 * 解决办法：
 * 1、getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
 * 2、在此控件的父布局上加入属性：android:focusable="true"   android:focusableInTouchMode="true"
 */
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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                ToastUtil.getInstance().setText("click:" + actionId);
                return false;
            }
        });
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.button:
//                testWindowMananger(view);
                testLog();
                break;
        }
    }

    private void testLog() {
        String s = LogUtil.generateTag();
        ToastUtil.getInstance().setText(s);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
//            if(v != et) {
//            if (KeyboardUtil.isShouldHideInput(v, ev))
                  /*  if (KeyboardUtil.hideInputMethod(this, v)) {
                        et.clearFocus();
                        return true;//隐藏键盘时，其他控件不响应点击事件==>注释掉则不拦截事件
                    }*/
//                }

            if (v != null && v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);//这个方法获取的Rect值不受输入法弹出与否的影响，但getRawX和getRawY受输入法弹出与否的影响
                if (!outRect.contains((int) ev.getRawX(), (int) ev.getRawY())) {
                    v.clearFocus();
                    Log.e("point", "edittext的GlobalVisibleRect：" + outRect + "点击事件：（" + ev.getRawX() + "," + ev.getRawY() + ")");
                    KeyboardUtil.hideInputMethod(this, v);
                    return true;
                }
//                if (!KeyboardUtil.touchOnEdittext(v, ev)) {
//                    KeyboardUtil.hideInputMethod(this, v);
//                    return true;
//                }
            }

        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 测试windowmanager
     *
     * @param view
     */
    private void testWindowMananger(final View view) {
        final WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.format = PixelFormat.TRANSPARENT;
        params.gravity = Gravity.CENTER;
        params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;


        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout v = (LinearLayout) inflater.inflate(R.layout.window, null);
        Button btn_sure = (Button) v.findViewById(R.id.btn_sure);
        Button btn_cancel = (Button) v.findViewById(R.id.btn_cancel);
        EditText et_account = (EditText) v.findViewById(R.id.et_account);
        final EditText et_pwd = (EditText) v.findViewById(R.id.et_pwd);
        CheckBox cb_showpwd = (CheckBox) v.findViewById(R.id.cb_showpwd);
        cb_showpwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示密码
                } else {
                    et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏密码
                }
                et_pwd.setSelection(TextUtils.isEmpty(et_pwd.getText()) ? 0 : et_pwd.getText().length());
            }
        });
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Rect temp = new Rect();
                view.getGlobalVisibleRect(temp);
                Log.e("TAG", "remove view");
                if (temp.contains((int) event.getX(), (int) event.getY())) {
                    windowManager.removeViewImmediate(view);
                    return true;
                }
                return false;
            }
        });
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "登录成功", Toast.LENGTH_SHORT).show();
                windowManager.removeViewImmediate(v);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "取消登录", Toast.LENGTH_SHORT).show();
                windowManager.removeViewImmediate(v);
            }
        });
        windowManager.addView(v, params);
    }
}
