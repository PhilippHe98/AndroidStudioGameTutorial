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
    private static final double SPEED_PIXELS_PER_SECOND = 600.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    public Player(Context context, double positionX, double positionY, double radius) {
        this.positionX = positionY;
        this.positionY = positionY;
        this.radius = radius;
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.red);
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
    }

    public void update(Joystick joystick) {
        double velocityX = joystick.getActuatorX() * MAX_SPEED;
        double velocityY = joystick.getActuatorY() * MAX_SPEED;
        positionX+= velocityX;
        positionY+=velocityY;

    }

    public void setPosition(float x, float y) {
        this.positionX = x;
        this.positionY = y;
    }
}
