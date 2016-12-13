package com.example.kryguu.accelerometer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kryguu on 13.12.2016.
 */

public class DrawView extends View {

    private Paint paint = new Paint();
    private int color = Color.BLACK;
    private float paintWidth = 10;
    private float x = 100;
    private float y = 100;

    public DrawView(Context context) {
        super(context);
        setPaint(color, paintWidth);
    }
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPaint(color, paintWidth);
    }
    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPaint(color, paintWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int centerY = canvas.getHeight()/2;
        int centerX = canvas.getWidth()/2;
        int endX = (int) (centerX-x);
        int endY = (int) (centerY-y);

        canvas.drawLine(centerX, centerY, endX, endY, paint);
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public void setPaint(int color, float width) {
        paint.setColor(color);
        paint.setStrokeWidth(width);
    }
}
