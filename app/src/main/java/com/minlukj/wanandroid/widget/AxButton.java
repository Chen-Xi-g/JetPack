package com.minlukj.wanandroid.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.minlukj.wanandroid.R;

public class AxButton extends AppCompatButton {
    //圆角半径
    private int cornerRadius = 0;
    //边框宽度
    private int borderStroke = 0;
    //边框颜色
    private int borderColor = 0;
    //enable为false时的颜色
    private int unableColor = 0;
    //背景shape
    private GradientDrawable shape;
    private int colorId;
    private int alpha;
    private boolean unable;

    public AxButton(Context context) {
        super(context,null,R.attr.AxButtonStyle);
    }

    public AxButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.AxButtonStyle);
    }

    public AxButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(shape == null) {
            shape = new GradientDrawable();
        }

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AxButton, 0, 0);
        cornerRadius = (int) a.getDimension(R.styleable.AxButton_corner_radius, 0);
        borderStroke = (int) a.getDimension(R.styleable.AxButton_border_stroke, 0);
        borderColor = a.getColor(R.styleable.AxButton_border_color, 0);
        unableColor = a.getColor(R.styleable.AxButton_unable_color, Color.DKGRAY);

        ColorDrawable buttonColor = (ColorDrawable) getBackground();
        colorId = buttonColor.getColor();
        alpha = 255;

        if(unable) {
            shape.setColor(unableColor);
        }else{
            shape.setColor(colorId);
        }
        a.recycle();
        init();
    }

    private void init() {
        //设置圆角半径
        shape.setCornerRadius(cornerRadius);
        //设置边框宽度和颜色
        shape.setStroke(borderStroke, borderColor);
        //将GradientDrawable设置为背景
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(shape);
        } else {
            setBackgroundDrawable(shape);
        }
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (pressed){
            shape.setAlpha((int) (alpha * 0.6));
            init();
        }else {
            shape.setAlpha(alpha);
            init();
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        unable = !enabled;
        if(shape != null) {
            shape = new GradientDrawable();
            if(unable) {
                shape.setColor(unableColor);
            }else{
                shape.setColor(colorId);
            }
            init();
        }
    }
}
