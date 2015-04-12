package com.ninja.game.collision;

import com.ninja.game.Edge;
import com.ninja.game.NinjaMath;
import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public class ReflectiveRectCollider extends ImmovableCollider {
    private float absorbtion;

    public float Absorbtion() {
        return absorbtion;
    }

    public ReflectiveRectCollider( WorldObject obj, float absorbtion) {
        super(obj);
        this.absorbtion = absorbtion;
    }

    public void DoCollision(CollidableMovingObject obj) {
        Edge nearestEdge = NinjaMath.NearestEdge(obj, this.obj);

        switch (nearestEdge) {
            case TOP:
                obj.setPosition(obj.getX(), this.obj.getY() + this.obj.getHeight());
                obj.setVelocity(obj.getVelX(),
                        -1 * NinjaMath.CalculateNewEnergy(obj.getVelY(), obj.getRetentivity(), absorbtion));
                break;
            case LEFT:
                obj.setPosition(this.obj.getX() - obj.getWidth(), obj.getY());
                obj.setVelocity(-1 * NinjaMath.CalculateNewEnergy(obj.getVelX(), obj.getRetentivity(), absorbtion),
                        obj.getVelY());
                break;
            case RIGHT:
                obj.setPosition(this.obj.getX() + this.obj.getWidth(), obj.getY());
                obj.setVelocity(-1 * NinjaMath.CalculateNewEnergy(obj.getVelX(), obj.getRetentivity(), absorbtion),
                        obj.getVelY());
                break;
            case BOTTOM:
                obj.setPosition(obj.getX(), this.obj.getY() - obj.getHeight());
                obj.setVelocity(obj.getVelX(),
                        -1 * NinjaMath.CalculateNewEnergy(obj.getVelY(), obj.getRetentivity(), absorbtion));
                break;
        }
    }
}