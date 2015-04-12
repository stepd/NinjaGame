package com.ninja.game.world;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Stephen Davis on 7/27/2014.
 */
public class CollidableMovingObject extends MovingObject {
    private float retentivity;

    public float getRetentivity() {
        return retentivity;
    }
    public CollidableMovingObject(Rectangle body, float retentivity) {
        super(body);
        this.retentivity = retentivity;
    }
}
