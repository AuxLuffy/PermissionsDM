package com.lenovo.sunzh.permissionsdm.utils;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by sunzh on 2017/7/11.
 */

public class KeyboardUtil {

    /**
     * 隐藏软键盘
     *
     * @param context
     * @param v
     * @return
     */
    public static boolean hideInputMethod(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            return imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        return false;
    }

    /**
     * 是否应该隐藏输入法
     *
     * @param v
     * @param event
     * @return
     */
    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0], top = leftTop[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            if (touchOnEdittext(v, event) || (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom)) {
                //保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 点击事件是否在edittext上
     *
     * @param v
     * @param event
     * @return
     */
    private static boolean touchOnEdittext(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0], top = leftTop[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            if (v.getLeft() < event.getX() && v.getRight() > event.getX() && v.getTop() < event.getY() && v.getBottom() > event.getY()) {
                return true;
            }
        }
        return false;
    }
}
