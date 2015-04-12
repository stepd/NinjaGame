package com.ninja.game.collision;

import com.badlogic.gdx.math.Rectangle;
import com.ninja.game.Edge;
import com.ninja.game.NinjaMath;
import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.MovingObject;
import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public class NonreflectiveRectCollider extends ImmovableCollider {
    public NonreflectiveRectCollider(WorldObject obj) {
        super( obj);
    }

    public void DoCollision(CollidableMovingObject obj) {
        Edge nearestEdge = NinjaMath.NearestEdge(obj, this.obj);

        switch (nearestEdge) {
            case TOP:
                obj.setPosition(obj.getX(), this.obj.getY() + this.obj.getHeight());
                obj.setVelocity(obj.getVelX(), 0);
                break;
            case LEFT:
                obj.setPosition(this.obj.getX() - obj.getWidth(), obj.getY());
                obj.setVelocity(0, obj.getVelY());
                break;
            case RIGHT:
                obj.setPosition(this.obj.getX() + this.obj.getWidth(), obj.getY());
                obj.setVelocity(0, obj.getVelY());
                break;
            case BOTTOM:
                obj.setPosition(obj.getX(), this.obj.getY() - obj.getHeight());
                obj.setVelocity(obj.getVelX(), 0);
                break;
        }
    }
}
