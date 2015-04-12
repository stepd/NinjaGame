package com.ninja.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ninja.game.Forces.Charge;
import com.ninja.game.Forces.Gravity;
import com.ninja.game.NinjaMath;
import com.ninja.game.UI.DebuggerOutput;
import com.ninja.game.world.CollidableMovingObject;

/**
 * Created by Stephen Davis on 2/7/2015.
 */
public class NinjaObject extends CollidableMovingObject {
    public static final float DEFAULT_CHARGE = 1f;

    Charge charge;
    boolean charging;
    boolean beingMoved;

    public boolean Charging() {
        return charging;
    }

    public NinjaObject(Rectangle body, float retentivity) {
        super(body, retentivity);

        charge = new Charge(DEFAULT_CHARGE);
    }

    @Override
    public void Update(float deltaTime) {

        if (charging)
            charge.Update(deltaTime);

        handleTouch();

        //DebuggerOutput.Output(Float.toString(charge.getPerc()));

        super.Update(deltaTime);
    }

    protected void handleTouch() { // Nothing is being done the first time except turning move on
        charging = false;

        if (!Gdx.input.isTouched()) {
            charge.Reset();
            beingMoved = false;
            return;
        }

        //DebuggerOutput.Output("Touched");

        if (!beingMoved) {
            if (withinTouchSpace()) {
                beingMoved = true;
            } else {
                return;
            }
        }

        //DebuggerOutput.Output("Moved");

        if (Gdx.input.isTouched(1)) {
                charging = true;
            //DebuggerOutput.Output("Charged");
        }
        //else
        //{
            Vector2 vel = new Vector2(Gdx.input.getX() - getOriginX(), Gdx.graphics.getHeight() - Gdx.input.getY() - getOriginY());
            vel = vel.nor();
            setVelocity(vel.x * (20 + 20 * charge.getPerc()), vel.y * (20 + 20 * charge.getPerc()));
            setAcceleration(0f, Gravity.getGravity() / 10);

            //DebuggerOutput.Output("Accelerated");
        //}
    }

    protected boolean withinTouchSpace() {
        return NinjaMath.Distance(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(),
                getOriginX(), getOriginY()) < getRadius()*2;
    }
}
