package com.ninja.game.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ninja.game.NinjaMath;
import com.ninja.game.causeandeffect.Affectable;

import javax.swing.text.Position;
import java.util.List;

/**
 * Created by Stephen Davis on 7/26/2014.
 */
public class WorldObject implements Affectable{
    private float radius;
    private Vector2 origin;
    private Rectangle body;

    public float getRadius() {
        return  radius;
    }

    public Vector2 getOrigin(Vector2 origin) {
        origin.x = this.origin.x;
        origin.y = this.origin.y;
        return origin;
    }

    public float getOriginX() {
        return origin.x;
    }

    public float getOriginY() {
        return origin.y;
    }

    public Vector2 getPosition(Vector2 position) {
        return body.getPosition(position);
    }

    public float getX() {
        return body.x;
    }

    public float getY() {
        return body.y;
    }

    public float getWidth() { return body.getWidth(); }

    public float getHeight() { return body.getHeight(); }

    public void setPosition(Vector2 position) {
        setPosition(position.x, position.y);
    }

    public void setPosition(float x, float y) {
        body.setX(x);
        body.setY(y);
        UpdateOrigin();
    }

    public Rectangle getRectangle(Rectangle rect) {
        return rect.set(body);
    }

    public boolean contains(float x, float y) { return body.contains(x, y); }

    public WorldObject(Rectangle body) {
        this.body = body;

        origin = new Vector2();
        UpdateOrigin();

        radius = (float)NinjaMath.Distance(origin.x, origin.y, body.x, body.y);
    }

    private void UpdateOrigin() {
        body.getCenter(origin);
    }

    @Override
    public void TriggerEffect(String effectName, List<Object> params) {

    }
}
