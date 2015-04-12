package com.ninja.game.Forces;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class Gravity {
    public static float DEFAULT_GRAVITY = -9.8f;
    static float gravity = DEFAULT_GRAVITY;

    public static float getGravity() {
        return gravity;
    }
}
