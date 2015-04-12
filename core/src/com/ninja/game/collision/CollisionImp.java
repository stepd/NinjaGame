package com.ninja.game.collision;

import com.ninja.game.world.MovingObject;
import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public abstract class CollisionImp {
    public abstract boolean Collides(WorldObject obj1, WorldObject obj2);
}
