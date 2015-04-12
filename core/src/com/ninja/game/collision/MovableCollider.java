package com.ninja.game.collision;

import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.MovingObject;
import sun.text.resources.CollationData_is;

/**
 * Created by Stephen Davis on 7/27/2014.
 */
public abstract class MovableCollider extends Collider {
    protected CollidableMovingObject obj;

    public MovableCollider(CollidableMovingObject obj) {
        this.obj = obj;
    }

    public abstract void DoCollision(CollidableMovingObject obj);

    public boolean Collides(CollidableMovingObject obj) {
        return collisionImp.Collides(obj, this.obj);
    }
}
