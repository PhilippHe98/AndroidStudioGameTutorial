package com.example.myapplication.object;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.myapplication.GameLoop;
import com.example.myapplication.R;

public class Enemy extends Circle {

    private static final double SPAWNS_PER_MINUTE = 20;
    private static final double SPAWNS_PER_SECOND = SPAWNS_PER_MINUTE / 60;
    private static final double UPDATES_PER_SPAWN = GameLoop.MAX_UPS / SPAWNS_PER_SECOND;
    private static double updatesUntilNextSpawn = UPDATES_PER_SPAWN;
    private final Player player;
    private final double SPEED_PIXELS_PER_SECOND = 400;
    private final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    public Enemy(Context context, double positionX, double positionY, double radius, Player player) {
        super(context, ContextCompat.getColor(context, R.color.teal_200), positionX, positionY, radius);
        this.player = player;
    }

    public Enemy(Context context, Player player) {
        super(
                context,
                ContextCompat.getColor(context, R.color.teal_200),
                Math.random()*1000,
                Math.random()*1000,
                30);
        this.player = player;
    }

    public static boolean readToSpawn() {
        if (updatesUntilNextSpawn <= 0) {
            updatesUntilNextSpawn += UPDATES_PER_SPAWN;
            return true;
        } else {
            updatesUntilNextSpawn--;
            return false;
        }
    }

    @Override
    public void update() {
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        double distanceToPlayer = getDistanceBetweenObjects(this, player);
        assert (distanceToPlayer != 0);
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
