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

    /**
     *
     * @param c1
     * @param c2
     * @return
     */
    public static boolean isColliding(Circle c1, Circle c2) {
        double distance = getDistanceBetweenObjects(c1,c2);
        double distanceToCollision = c1.getRadius() + c2.getRadius();
        if(distance < distanceToCollision) return true;
        return false;
    }

    private double getRadius() {
        return this.radius;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
    }
}
