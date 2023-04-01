package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player {
    private double positionX;
    private double positionY;
    private double radius;
    private Paint paint;

    public Player(Context context, double positionX, double positionY, double radius) {
        this.positionX = positionY;
        this.positionY = positionY;
        this.radius = radius;
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.red);
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float)positionX,(float) positionY, (float) radius, paint);
    }

    public void update() {
    }

    public void setPosition(float x, float y) {
        this.positionX = x;
        this.positionY = y;
    }
}
