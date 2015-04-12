package com.ninja.game.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ninja.game.Updatable;

/**
 * Created by Stephen Davis on 7/26/2014.
 */
public class MovingObject extends WorldObject implements Updatable {
    private Vector2 velocity, acceleration;

    public Vector2 getVelocity(Vector2 velocity) {
        velocity.x = this.velocity.x;
        velocity.y = this.velocity.y;
        return velocity;
    }

    public float getVelX() {
        return velocity.x;
    }

    public float getVelY() {
        return velocity.y;
    }

    public Vector2 getAcceleration(Vector2 acceleration) {
        acceleration.x = this.acceleration.x;
        acceleration.y = this.acceleration.y;
        return acceleration;
    }

    public float getAccelX() {
        return acceleration.x;
    }

    public float getAccelY() {
        return acceleration.y;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity.set(velocity);
    }

    public void setVelocity(float velX, float velY) {
        velocity.x = velX;
        velocity.y = velY;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration.set(acceleration);
    }

    public void setAcceleration(float accelX, float accelY) {
        acceleration.x = accelX;
        acceleration.y = accelY;
    }

    public MovingObject(Rectangle body) {
        super(body);

        velocity = new Vector2();
        acceleration = new Vector2();
    }

    public void Update(float deltaTime) {
        Accelerate();
        Move();
    }

    public void Move() {
        setPosition(getX() + getVelX(), getY() + getVelY());
    }

    public void Accelerate() {
        setVelocity(getVelX() + getAccelX(), getVelY() + getAccelY());
    }
}
