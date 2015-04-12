package com.ninja.game.Forces;

import com.ninja.game.Updatable;

/**
 * Created by Stephen Davis on 2/4/2015.
 */
public class Charge implements Updatable {
    public static float DEFAULT_RATE = 1f;

    float perc,
          rate;

    public float getPerc() { return perc>1.0f?1.0f:perc; }
    public boolean Charged() { return getPerc() == 1.0f; }

    public Charge() { this(DEFAULT_RATE); }
    public Charge(float rate) { this.rate = rate; }

    public void Reset() { perc = 0.0f; }

    public void Update(float deltaTime) { perc += deltaTime/rate; }
}
