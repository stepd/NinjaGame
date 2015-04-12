package com.ninja.game.animation;

import com.ninja.game.causeandeffect.Effect;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class ActionFrame {
    private float duration;
    private Effect effect;
    private Sprite sprite;

    public Sprite getSprite(){
        return sprite;
    }

    public float getDuration() {
        return duration;
    }

    public ActionFrame(float duration, Sprite sprite) {
        this.duration = duration;
        this.sprite = sprite;
    }

    public  ActionFrame(float duration, Sprite sprite, Effect effect) {
        this(duration, sprite);
        this.effect = effect;
    }

    public void Trigger() {
        if (effect != null)
            effect.Trigger();
    }
}
