package com.ninja.game.collision;

import com.ninja.game.causeandeffect.Effect;
import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.MovingObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public class EffectCollider {
    private Collider collider;
    private Effect effect;

    public  boolean TryCollide(CollidableMovingObject obj) {
        if (collider.TryCollide(obj)) {
            effect.setTarget(obj);
            effect.Trigger();
            return true;
        }

        return false;
    }
}
