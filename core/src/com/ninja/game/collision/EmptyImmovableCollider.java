package com.ninja.game.collision;

import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public class EmptyImmovableCollider extends ImmovableCollider {

    public EmptyImmovableCollider(WorldObject obj) {
        super(obj);
    }

    public void DoCollision(CollidableMovingObject obj) {}
}
