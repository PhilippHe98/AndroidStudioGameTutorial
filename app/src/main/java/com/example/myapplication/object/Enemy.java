package com.example.myapplication.object;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.myapplication.GameLoop;
import com.example.myapplication.R;

public class Enemy extends Circle {

    private final Player player;
    private final double SPEED_PIXELS_PER_SECOND = 400;
    private final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    public Enemy(Context context, double positionX, double positionY, double radius, Player player) {
        super(context, ContextCompat.getColor(context, R.color.teal_200), positionX, positionY, radius);
        this.player = player;
    }

    @Override
    public void update() {
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        double distanceToPlayer = getDistanceBetweenObjects(this, player);
        assert(distanceToPlayer != 0);
        double directionX = distanceToPlayerX / distanceToPlayer;
        double directionY = distanceToPlayerY / distanceToPlayer;

        if (distanceToPlayer > 0) {
            velocityX = directionX * MAX_SPEED;
            velocityY = directionY * MAX_SPEED;
        } else {
            velocityX = 0;
            velocityY = 0;
        }
        positionX += velocityX;
        positionY += velocityY;
    }
}
