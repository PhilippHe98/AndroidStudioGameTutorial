package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player extends Circle {
    private static final double SPEED_PIXELS_PER_SECOND = 600.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private final Joystick joystick;

    public Player(Context context, double positionX, double positionY, double radius, Joystick joystick) {
        super(context, positionX, positionY, radius);
        this.joystick = joystick;
    }

    public void update() {
        double velocityX = joystick.getActuatorX() * MAX_SPEED;
        double velocityY = joystick.getActuatorY() * MAX_SPEED;

        positionX += velocityX;
        positionY += velocityY;
    }
}
