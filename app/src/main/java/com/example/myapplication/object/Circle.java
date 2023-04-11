package com.example.myapplication.object;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Circle extends GameObject{
    private double radius;
    private Paint paint;

    public Circle(Context context, int color ,double positionX, double positionY, double radius) {
        super(positionX, positionY);
        this.radius = radius;
        paint = new Paint();
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
    }
}
