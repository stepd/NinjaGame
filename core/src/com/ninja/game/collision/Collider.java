package com.ninja.game.collision;

import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.MovingObject;
import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/27/2014.
 */
public abstract class Collider {
    protected CollisionImp collisionImp;

    public Collider() {
        collisionImp = CircleBoundRectCollison.IMP;
    }
    public Collider(CollisionImp collisionImp) {
        this.collisionImp = collisionImp;
    }
    protected abstract void DoCollision(CollidableMovingObject obj);
    public boolean TryCollide(CollidableMovingObject obj) {
        if (Collides(obj)) {
            DoCollision(obj);
            return true;
        }
        return false;
    }
    public abstract boolean Collides(CollidableMovingObject obj);
}
