package com.ninja.game.collision;

import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.MovingObject;
import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public abstract class ImmovableCollider extends Collider {
    protected WorldObject obj;

    public ImmovableCollider(WorldObject obj) {
        this.obj = obj;
    }

    public abstract void DoCollision(CollidableMovingObject obj);

     public boolean Collides(CollidableMovingObject obj) {
        return collisionImp.Collides(obj, this.obj);
    }
}
