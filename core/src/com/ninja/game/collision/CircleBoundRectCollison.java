package com.ninja.game.collision;

import com.badlogic.gdx.math.Rectangle;
import com.ninja.game.NinjaMath;
import com.ninja.game.world.MovingObject;
import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public class CircleBoundRectCollison extends CollisionImp {

    public static final CircleBoundRectCollison IMP;

    static {
        IMP = new CircleBoundRectCollison();
    }

    @Override
    public boolean Collides(WorldObject obj1, WorldObject obj2) {
        if (NinjaMath.Distance(obj1.getOriginX(), obj1.getOriginY(),
                               obj2.getOriginX(), obj2.getOriginY())
                < obj1.getRadius() + obj2.getRadius()) {
            return obj1.getRectangle(new Rectangle()).overlaps(obj2.getRectangle(new Rectangle()));
        }
        return false;
    }
}
