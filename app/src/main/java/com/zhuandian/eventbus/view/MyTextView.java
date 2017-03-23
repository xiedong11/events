package com.zhuandian.eventbus.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.zhuandian.eventbus.R;

/**
 * Created by xiedong on 2017/3/22.
 */

public class MyTextView extends View {

    private String text;
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.myText);


        text = ta.getString(R.styleable.myText_text);
        int color = ta.getColor(R.styleable.myText_textColor,0xff0000ff);
        int bg_color = ta.getColor(R.styleable.myText_bg,0xff000000);


        System.out.println(text+"        "+color+"        "+bg_color);
        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
