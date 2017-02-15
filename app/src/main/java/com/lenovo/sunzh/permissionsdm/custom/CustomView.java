package com.lenovo.sunzh.permissionsdm.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.lenovo.sunzh.permissionsdm.R;

/**
 * 自定义view
 * Created by sunzh on 2017/2/10.
 */

public class CustomView extends View {
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本颜色
     */
    private int mTitleTextColor;
    /**
     * 文本大小
     */
    private int mTitleTextSize;
    /**
     * 控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int index = a.getIndex(i);
            switch (index) {
                case R.styleable.CustomView_titleText:
                    mTitleText = a.getString(index);
                    break;
                case R.styleable.CustomView_titleTextSize:
                    //默认大小设为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(index, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomView_titleTextColo:
                    //默认颜色设为黑色
                    mTitleTextColor = a.getColor(index, Color.BLACK);
                    break;
            }
        }
        a.recycle();
        /**
         * 获取绘制文本的宽、高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widtSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widtSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            int textWidth = mBound.width();
            int desiredWidth = getPaddingLeft() + textWidth + getPaddingRight();
            width = desiredWidth;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            int textHeight = mBound.height();
            int desiredHeight = getPaddingTop() + getPaddingBottom() + textHeight;
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);//用来存储测量好的实际长度
    }
}
